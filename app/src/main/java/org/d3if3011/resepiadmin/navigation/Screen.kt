package org.d3if3011.resepiadmin.navigation

sealed class Screen(val route: String) {
    data object DashboardAdminPage: Screen("homeScreen")
    data object DetailResepPage: Screen("detailScreen")
    data object TambahResepPage: Screen("tambahResepScreen")
}