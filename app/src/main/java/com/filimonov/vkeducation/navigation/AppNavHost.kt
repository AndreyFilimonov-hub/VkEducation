package com.filimonov.vkeducation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.filimonov.vkeducation.appscreen.AppDetails
import com.filimonov.vkeducation.appscreen.Category
import com.filimonov.vkeducation.appscreen.SimilarApp
import com.filimonov.vkeducation.appscreen.navigation.AppRoute
import com.filimonov.vkeducation.appscreen.ui.AppDetailsContent
import com.filimonov.vkeducation.appscreen.ui.AppDetailsState
import com.filimonov.vkeducation.listscreen.navigation.ListRoute
import com.filimonov.vkeducation.listscreen.ui.ListScreen

@Composable
fun AppNavHost() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ListRoute
    ) {
        composable<ListRoute> {
            ListScreen(
                onAppClick = {
                    navController.navigate(AppRoute)
                }
            )
        }
        composable<AppRoute> {
            AppDetailsContent(
                content = AppDetailsState.Content(
                    appDetails = AppDetails(
                        id = "fa2e31b8-1234-4cf7-9914-108a170a1b01",
                        name = "Гильдия Героев: Экшен ММО РПГ",
                        developer = "VK Play",
                        category = Category.GAME,
                        ageRating = 12,
                        size = 223.7f,
                        screenshotUrlList = listOf(
                            "https://static.rustore.ru/imgproxy/-y8kd-4B6MQ-1OKbAbnoAIMZAzvoMMG9dSiHMpFaTBc/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/dfd33017-e90d-4990-aa8c-6f159d546788.jpg@webp",
                            "https://static.rustore.ru/imgproxy/dZCvNtRKKFpzOmGlTxLszUPmwi661IhXynYZGsJQvLw/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/60ec4cbc-dcf6-4e69-aa6f-cc2da7de1af6.jpg@webp",
                            "https://static.rustore.ru/imgproxy/g5whSI1uNqaL2TUO7TFfM8M63vXpWXNCm2vlX4Ahvc4/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/c2dde8bc-c4ab-482a-80a5-2789149f598d.jpg@webp",
                            "https://static.rustore.ru/imgproxy/TjeurtC7BczOVJt74XhjGYuQnG1l4rx6zpDqyMb00GY/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/08318f76-7a9c-43aa-b4a7-1aa878d00861.jpg@webp",
                        ),
                        iconUrl = "https://static.rustore.ru/imgproxy/APsbtHxkVa4MZ0DXjnIkSwFQ_KVIcqHK9o3gHY6pvOQ/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/393868735/content/ICON/3f605e3e-f5b3-434c-af4d-77bc5f38820e.png@webp",
                        description = "Легендарный рейд героев в Фэнтези РПГ. Станьте героем гильдии и зразите мастера подземелья!"
                    ),
                    similarApps = List(15) { index ->
                        SimilarApp(
                            id = "similar-app-$index",
                            name = "Гильдия Героев: Экшен ММО РПГ: $index",
                            iconUrl = "https://static.rustore.ru/imgproxy/APsbtHxkVa4MZ0DXjnIkSwFQ_KVIcqHK9o3gHY6pvOQ/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/393868735/content/ICON/3f605e3e-f5b3-434c-af4d-77bc5f38820e.png@webp",
                        )
                    },
                    descriptionCollapsed = false,
                ),
                onReadMoreClick = {},
                onBackClick = {
                    navController.popBackStack()
                },
                onShareClick = {},
                onInstallClick = {},
                onDeveloperClick = {},
                onShowcaseAppClick = {
                    navController.navigate(ListRoute)
                },
                onSimilarAppDownloadClick = {}
            )
        }
    }
}