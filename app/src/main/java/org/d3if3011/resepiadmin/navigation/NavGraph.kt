package org.d3if3011.resepiadmin.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.d3if3011.resepi.ui.screen.AdminDashboardScreen
import org.d3if3011.resepi.ui.screen.AdminTambahResepScreen
import org.d3if3011.resepiadmin.ui.screen.AdminDetailScreen

@Composable
fun SetupNavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController, startDestination = Screen.DashboardAdminPage.route
    ) {
        composable(route = Screen.DashboardAdminPage.route) {
            AdminDashboardScreen(navController)
        }
        composable(route = Screen.DetailResepPage.route) {
            AdminDetailScreen(navController, "")
        }
        composable(route = Screen.TambahResepPage.route) {
            AdminTambahResepScreen(navController)
        }

    }
}