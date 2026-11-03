package com.filimonov.vkeducation.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.filimonov.vkeducation.presentation.appscreen.AppDetailsScreen
import com.filimonov.vkeducation.presentation.appscreen.navigation.AppRoute
import com.filimonov.vkeducation.presentation.listscreen.ListScreen
import com.filimonov.vkeducation.presentation.listscreen.navigation.ListRoute

@Composable
fun AppNavHost() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ListRoute
    ) {
        composable<ListRoute> {
            ListScreen(
                onAppClick = { id ->
                    navController.navigate(AppRoute(id))
                }
            )
        }
        composable<AppRoute> { backStackEntry ->
            val route = backStackEntry.toRoute<AppRoute>()

            AppDetailsScreen(
                id = route.id,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
