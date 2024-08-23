package com.example.yourlicey28.presentation.home.components.popular.teacher

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.yourlicey28.R
import com.example.yourlicey28.domain.model.Teacher
import com.example.yourlicey28.presentation.activityComponents.WelcomeRoutes
import com.example.yourlicey28.ui.theme.LightBlueLC

@Composable
fun MyTeachersScreen(navController: NavHostController) {
    val data = listOf(
        Teacher(
            id = R.drawable.teacher1,
            name = "Ушакова Елена Викторовна",
            info = "Директор лицея, учитель истории и обществознания высшей квалификационной категории. Образование в области менеджмента организации: Президентская программа переподготовки\n" +
                    "управленческих кадров по специальности «Менеджмент».",
            email = "elenaushakova0405@gmail.com"
        ),
        Teacher(
            id = R.drawable.zarembanad,
            name = "Заремба Надежда Владимировна",
            info = "Зам.директора по УВР, учитель истории и обществознания высшей квалификационной категории.",
            email = "nadzaremba@yandex.ru"
        ),
        Teacher(
            id = R.drawable.p41_kondrat_evaelenamixaylovna,
            name = "Кондратьева Елена Михайловна",
            info = "Зам. директора по УВР, учитель начальных классов высшей квалификационной категории.",
            email = "elenaaandreewa@gmail.com"
        ),
        Teacher(
            id = R.drawable.panakovao,
            name = "Панакова Ольга Юрьевна",
            info = "Зам. директора по ВР, учитель русского языка и литературы высшей квалификационной категории.",
            email = "opanakova88@gmail.com"
        ),
        Teacher(
            id = R.drawable.p41_mogil_nayairinanikolaevna,
            name = "Могильная Ирина Николаевна",
            info = "Педагог-организатор ОБЖ высшей квалификационной категории.",
            email = "irinamogilnaa411@mail.ru"
        ),
        Teacher(
            id = R.drawable.p41_chernikovaol_gaivanovna,
            name = "Черникова Ольга Ивановна",
            info = "Социальный педагог высшей квалификационной категории, учитель биологии.",
            email = " "
        ),
        Teacher(
            id = R.drawable.p41_murashevgennadiydmitrievich,
            name = "Мурашев Геннадий Дмитриевич",
            info = "Учитель физики и спец.предметов высшей калификационной категории.",
            email = "murasevg52@gmail.com"
        ),
        Teacher(
            id = R.drawable.p41_iskragalinanikolaevna,
            name = "Искра Галина Николаевна",
            info = "Организатор внеклассной работы, руководитель музея.",
            email = " "
        ),
        Teacher(
            id = R.drawable.p41_luk_yanovalarisamixaylovn,
            name = "Лукьянова Лариса Михайловна",
            info = "Учитель начальных классов высшей квалификационной категории.",
            email = "lukyanowa_larisa@mail.com"
        ),
        Teacher(
            id = R.drawable.p41_mityushinanatal_yavital_evna,
            name = "Митюшина Наталья Витальевна",
            info = "Учитель начальных классов высшей квалификационной категории.",
            email = "nmitiushina@mail.ru"
        ),
        Teacher(
            id = R.drawable.p41_shestakovasvetlanavladimirovna,
            name = "Шестакова Светлана Владимировна",
            info = "Учитель начальных классов высшей квалификационной категории.",
            email = "ladyshestakova@yandex.ru"
        ),
        Teacher(
            id = R.drawable.p41_vlasovaelenavladimirovna,
            name = "Власова Елена Владимировна",
            info = "Учитель начальных классов первой квалификационной категории.",
            email = "vlasovaelena1108@gmail.com"
        ),
        Teacher(
            id = R.drawable.p41_img_4221_2,
            name = "Николаева Татьяна Алексеевна",
            info = "Учитель начальных классов высшей квалификационной категории.",
            email = "9137524666@gmail.com"
        ),
        Teacher(
            id = R.drawable.p41_korobkovamariyaolegovna,
            name = "Коробкова Мария Олеговна",
            info = "Учитель начальных классов.",
            email = ""
        ),
        Teacher(
            id = R.drawable.p41_semirenkoelenavladimirovna,
            name = "Семиренко Елена Владимировна",
            info = "Учитель начальных классов первой квалификационной категории.",
            email = "lena.semirenko123@gmail.com"
        ),
        Teacher(
            id = R.drawable.p41_kanevanuriyashamil_evna,
            name = "Канева Нурия Шамильевна",
            info = "Учитель начальных классов первой квалификационной категории.",
            email = "nuriakaneva@gmail.com"
        ),
        Teacher(
            id = R.drawable.p41_dudarevalarisaf_dorovna,
            name = "Дударева Лариса Фёдоровна",
            info = "Учитель начальных классов первой квалификационной категории.",
            email = "ldudareva038@gmail.com"
        ),
        Teacher(
            id = R.drawable.p41_shandrkristinayeduardovna,
            name = "Шандр Кристина Эдуардовна",
            info = "Учитель начальных классов.",
            email = "k_bulkova@inbox.ru"
        ),
        Teacher(
            id = R.drawable.p_41_globa,
            name = "Глоба Юлия Владимировна",
            info = "Учитель начальных классов.",
            email = " "
        ),
        Teacher(
            id = R.drawable.p41_petlyakgalinakonstantinovna,
            name = "Петляк Галина Константиновна",
            info = "Учитель-логопед, учитель-дефектолог.",
            email = " "
        ),
        Teacher(
            id = R.drawable.p41_sinyaginatat_yananikolaevna,
            name = "Жарикова Татьяна Николаевна",
            info = "Педагог психолог первой квалификационной категории.",
            email = " "
        ),

        Teacher(
            id = R.drawable.p41_rusyaznov,
            name = "Юсупова Гульнара Назиповна",
            info = "Учитель русского языка и литературы первой квалификационной категории.",
            email = " "
        ),

        Teacher(
            id = R.drawable.p41_shilool_gaviktorovna,
            name = "Шило Ольга Викторовна",
            info = "Учитель русского языка и литературы высшей квалификационной категории.",
            email = "olgashilo0022@gmail.com"
        ),

        Teacher(
            id = R.drawable.p41_shapovalovanatal_yavasil_evna,
            name = "Шаповалова Наталья Васильевна",
            info = "Учитель русского языка и литературы первой квалификационной категории.",
            email = "natalashapovalova621@gmail.com"
        ),

        Teacher(
            id = R.drawable.p41_whatsappimage2021_09_12at163301,
            name = "Петроченко Наталья Борисовна",
            info = "Учитель русского языка и литературы первой квалификационной категории.",
            email = "voinovanatali@ngs.ru"
        ),

        Teacher(
            id = R.drawable.p41_ladyiginaanastasiyaaleksandrovna,
            name = "Ладыгина Анастасия Александровна",
            info = "Учитель русского языка и литературы.",
            email = "ohladygina@gmail.com"
        ),

        Teacher(
            id = R.drawable.p41_logunovaannanikolaevna,
            name = "Логунова Анна Николаевна",
            info = "Педагог библиотекарь.",
            email = "bibliolicey28@gmail.com"
        ),

        Teacher(
            id = R.drawable.p41_ivanovaevgeniyagennad_evna,
            name = "Иванова Евгения Геннадьевна",
            info = "Учитель иностранного языка первой квалификационной категории.",
            email = "egivanova9@gmail.com"
        ),

        Teacher(
            id = R.drawable.p41_taras_kinamarinaalekseevna,
            name = "Тараськина Марина Алексеевна",
            info = "Учитель иностранного языка первой квалификационной категории.",
            email = "taraskina28@yandex.ru"
        ),

        Teacher(
            id = R.drawable.p41_yugaynadejdasergeevna,
            name = "Югай Надежда Сергеевна",
            info = "Учитель иностранного языка первой квалификационной категории.",
            email = "Yugay288@gmail.com"
        ),

        Teacher(
            id = R.drawable.p41_rublevmaksimgrigor_evich,
            name = "Рублев Максим Григорьевич",
            info = "Учитель географии и биологии.",
            email = " "
        ),


        Teacher(
            id = R.drawable.p41_kalinkinaol_gavladimirovna,
            name = "Калинкина Ольга Владимировна",
            info = "Учитель иностранного языка.",
            email = "kalinkinakgmu@mail.ru"
        ),


        Teacher(
            id = R.drawable.p41_xrushaevaelenapetrovna,
            name = "Хрущева Елена Петровна",
            info = "Учитель математики и информатики высшей квалификационной категории.",
            email = "elenahruscheva1964@gmail.com"
        ),

        Teacher(
            id = R.drawable.p41_jil_nikovasvetlanamixaylovna,
            name = "Жильникова Светлана Михайловна",
            info = "Учитель математики первой квалификационной категории.",
            email = "zhilnikovasveta@yandex.ru"
        ),

        Teacher(
            id = R.drawable.p41_suxachevaelenamoiseevna,
            name = "Сухачева Елена Моисеевна",
            info = "Учитель математики высшей квалификационной категории.",
            email = "elena.sukha4eva@yandex.ru"
        ),


        Teacher(
            id = R.drawable.p41_dsc_1825_5128,
            name = "Новикова Ирина Павловна",
            info = "Учитель математики высшей квалификационной категории.",
            email = "novikova7261455@gmail.com"
        ),

        Teacher(
            id = R.drawable.p41_pavilanaygul_kadyirjanovna,
            name = "Павилан Айгуль Кадыржановна",
            info = "Учитель математики и информатики первой квалификационной категории.",
            email = "vladka26032006@gmail.com"
        ),

        Teacher(
            id = R.drawable.p41_beglaryannellialekovna,
            name = "Бегларян Нелли Алековна",
            info = "Учитель математики первой квалификационной категории.",
            email = "Nelli-nnnb@mail.ru"
        ),


        Teacher(
            id = R.drawable.p41_ful_manelenanikolaevna,
            name = "Фульман Елена Николаевна",
            info = "Учитель информатики первой квалификационной категории.",
            email = "elenafulman@yandex.ru"
        ),


        Teacher(
            id = R.drawable.p41_maklakova,
            name = "Маклакова Надежда Олеговна",
            info = "Учитель математики.",
            email = "maclackova.nadezhda@yandex.ru"
        ),


        Teacher(
            id = R.drawable.no_ph,
            name = "Анжиганова Марина Сергеевна",
            info = "Учитель иностранного языка первой квалификационной категории.",
            email = " "
        ),


        Teacher(
            id = R.drawable.p41_aleksandrovanatal_yaaleksandrovna,
            name = "Александрова Наталья Александровна",
            info = "учитель истории и обществознания первой квалификационной категории.",
            email = "anatalia2@yandex.ru"
        ),


        Teacher(
            id = R.drawable.p41_gaasallavladimirovna,
            name = "Гаас Алла Владимировна",
            info = "Учитель истории и обществознания",
            email = "gaasss@yandex.ru"
        ),


        Teacher(
            id = R.drawable.p41_ksenofontovaelenavladimirovna,
            name = "Ксенофонтова Елена Владимировна",
            info = "Учитель физики высшей квалификационной категории.",
            email = "fizlicey.28@gmail.com"
        ),

        Teacher(
            id = R.drawable.p41_sutyaginairinaaleksandrovna,
            name = "Сутягина Ирина Александровна",
            info = "Учитель химии высшей квалификационной категории.",
            email = "belka-dima@mail.ru"
        ),

        Teacher(
            id = R.drawable.p41_lobanovaelenaanatol_evna,
            name = "Лобанова Елена Анатольевна",
            info = "Учитель биологии и химии первой квалификационной категории.",
            email = "biologia282020@gmail.com"
        ),

        Teacher(
            id = R.drawable.p41_shitikovanatal_yavaler_evna,
            name = "Шитикова Наталья Валерьевна",
            info = "Учитель географии первой квалификационной категории.",
            email = "nataljachitik@gmail.com"
        ),

        Teacher(
            id = R.drawable.p41_pisarevskayamarinavladimirovna,
            name = "Писаревская Марина Владимировна",
            info = "Учитель музыки первой квалификационной категории.",
            email = "marinapisarevskaya71@gmail.com"
        ),

        Teacher(
            id = R.drawable.p41_verigovladimirvalentinovich,
            name = "Вериго Владимир Валентинович",
            info = "Учитель технологии высшей квалификационной категории.",
            email = " "
        ),

        Teacher(
            id = R.drawable.p41_klimovairinaigorevna,
            name = "Климова Ирина Игоревна",
            info = "Учитель технологии первой квалификационной категории.",
            email = "VIAS_Irina@mail.ru"
        ),

        Teacher(
            id = R.drawable.p41_vesninanataliyavladimirovna,
            name = "Веснина Наталия Владимировна",
            info = "Учитель физической культуры высшей квалификационной категории.",
            email = "nv.vesnina1968@gmail.com"
        ),

        Teacher(
            id = R.drawable.p41_shabulinevgeniyolegovich,
            name = "Шабулин Евгений Олегович",
            info = "Учитель физической культуры высшей квалификационной категории.",
            email = "sabulin1985@mail.ru"
        ),
        Teacher(
            id = R.drawable.p41_nevrovvladimiralekseevich,
            name = "Невров Владимир Алексеевич",
            info = "Учитель физической культуры высшей квалификационной категории.",
            email = "vladimirnevrov213@gmail.com"
        ),
        Teacher(
            id = R.drawable.p41_smyikovanatal_yavladimirovna,
            name = "Смыкова Наталья Владимировна",
            info = "Учитель физической культуры первой квалификационной категории.",
            email = "nata.smykova.1969@gmail.com"
        ),
        Teacher(
            id = R.drawable.p41_gantimurovaol_naborisovna,
            name = "Гантимурова Ольга Борисовна",
            info = "Учитель начальных классов высшей квалификационной категории.",
            email = " "
        ),
        Teacher(
            id = R.drawable.p41_malyakinalarisavladimirovna,
            name = "Малякина Лариса Владимировна",
            info = "Учитель изобразительного искусства.",
            email = " "
        ),
        Teacher(
            id = R.drawable.p41_korobkovamariyaolegovna,
            name = "Коробкова Мария Олеговна",
            info = "Учитель начальных классов.",
            email = " "
        ),
        Teacher(
            id = R.drawable.p41_golubevatat_yanayur_evna,
            name = "Голубева Татьяна Юрьевна",
            info = "Учитель иностранного языка первой квалификационной категории.",
            email = " "
        )
    )

    Column(
    ) {
        LazyColumn(
            modifier = Modifier.padding(top = 10.dp),
            contentPadding = PaddingValues(9.dp)
        ) {
            items(data.size) { index ->
                TeacherCard(teacher = data[index])
            }
        }
    }
}
