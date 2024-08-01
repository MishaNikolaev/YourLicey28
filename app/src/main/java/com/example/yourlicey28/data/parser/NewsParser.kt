package com.example.yourlicey28.data.parser

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yourlicey28.domain.model.LinkTextData
import com.example.yourlicey28.domain.model.News
import com.example.yourlicey28.ui.theme.DarkBlueLC
import com.example.yourlicey28.ui.theme.monterrat
import com.example.yourlicey28.ui.theme.roboto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup
import java.util.regex.Pattern
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewParser @Inject constructor():Parser<News> {
    override suspend fun parse(): List<News> {
        return withContext(Dispatchers.IO) {
            val url = "http://s_28.edu54.ru/p96aa1.html"
            val doc = Jsoup.connect(url).get()

            val news = mutableListOf<News>()
            val text = doc.getElementById("text")
            val tbody = text?.getElementsByTag("tbody")?.get(0)
            val trs = tbody?.children()

            var counter = 1

            for (i in 1 until trs!!.size) {
                try {
                    var text = trs[i].getElementsByTag("td")[0].text()
                    val photo =
                        "http://www.s_28.edu54.ru/" + trs[i].getElementsByTag("td")[0].getElementsByTag(
                            "img"
                        ).first()!!
                            .attr("src")
                    if (text.isNotEmpty()) {
                        val pair = getHyperLinks(text)
                        if (pair.first != -1 && pair.second != -1) {
                            val listLinkTextData = listOf(
                                LinkTextData(
                                    text = text.substring(0, pair.first)
                                ),
                                LinkTextData(
                                    text = text.substring(pair.first, pair.second),
                                    tag = text.substring(pair.first, pair.second),
                                    annotation = text.substring(pair.first, pair.second)
                                ),
                                LinkTextData(
                                    text = text.substring(pair.second + 1, text.length),
                                )
                            )

                            news.add(
                                News(
                                    id = counter,
                                    text = listLinkTextData,
                                    photo = photo,
                                    favourite = false
                                )
                            )

                        } else {
                            news.add(
                                News(
                                    id = counter,
                                    text = listOf(
                                        LinkTextData(
                                            text = text
                                        )
                                    ),
                                    photo = photo,
                                    favourite = false
                                )
                            )
                        }
                    }
                } catch (ex: Exception) {

                }
                counter ++
            }
            news
        }
    }
}


private val urlPattern: Pattern = Pattern.compile(
    "(?:^|[\\W])((ht|f)tp(s?):\\/\\/|www\\.)"
            + "(([\\w\\-]+\\.){1,}?([\\w\\-.~]+\\/?)*"
            + "[\\p{Alnum}.,%_=?&#\\-+()\\[\\]\\*$~@!:/{};']*)",
    Pattern.CASE_INSENSITIVE or Pattern.MULTILINE or Pattern.DOTALL
)

private fun getHyperLinks(text: String): Pair<Int, Int> {
    val urlMatcher = urlPattern.matcher(text)
    var matchStart: Int = -1
    var matchEnd: Int = -1
    while (urlMatcher.find()) {
        matchStart = urlMatcher.start(1)
        matchEnd = urlMatcher.end()
        return Pair(matchStart, matchEnd)
    }
    return Pair(matchStart, matchEnd)
}

@Composable
fun LinkText(
    linkTextData: List<LinkTextData>,
    modifier: Modifier = Modifier,
    onClick: ((str: String) -> Unit)? = null
) {
    val annotatedString = createAnnotatedString(linkTextData)
    ClickableText(
        text = annotatedString,
        onClick = { offset ->
            linkTextData.forEach { annotatedStringData ->
                if (annotatedStringData.tag != null && annotatedStringData.annotation != null) {
                    annotatedString.getStringAnnotations(
                        tag = annotatedStringData.tag,
                        start = offset,
                        end = offset,
                    ).firstOrNull()?.let {
                        onClick?.invoke(it.item)
                    }
                }
            }
        },
        modifier = modifier,
    )
}

@Composable
private fun createAnnotatedString(data: List<LinkTextData>): AnnotatedString {
    return buildAnnotatedString {
        data.forEach { linkTextData ->
            if (linkTextData.tag != null && linkTextData.annotation != null) {
                pushStringAnnotation(
                    tag = linkTextData.tag,
                    annotation = linkTextData.annotation,
                )
                withStyle(
                    style = SpanStyle(
                        color = Color.Blue,
                        textDecoration = TextDecoration.Underline,
                        fontSize = 13.sp
                    ),
                ) {
                    append(linkTextData.text)
                }
                pop()
            } else {
                withStyle(
                    style = SpanStyle(
                        color = Color.Black,
                        fontFamily = roboto,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal
                    ),
                ) {
                    append(linkTextData.text)
                }
            }
        }
    }
}