package com.dwan.composeexample.compose

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dwan.composeexample.R
import com.dwan.composeexample.ui.notifications.NotificationsViewModel

sealed class BottomNavItem(var title: String, var icon: Int, var screen_route: String) {

    object Home : BottomNavItem("Home", R.drawable.ic_home_black_24dp, "home")
    object Dashboard : BottomNavItem("Dashboard", R.drawable.ic_dashboard_black_24dp, "dashboard")
    object Notification :
        BottomNavItem("Notification", R.drawable.ic_notifications_black_24dp, "notification")
}

@Composable
fun navigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.Home.screen_route) {
        composable(BottomNavItem.Home.screen_route) {
            HomeScreenView()
        }
        composable(BottomNavItem.Dashboard.screen_route) {
            DashboardScreenView()
        }
        composable(BottomNavItem.Notification.screen_route) {
            NotificationScreenView(NotificationsViewModel())
        }
    }
}