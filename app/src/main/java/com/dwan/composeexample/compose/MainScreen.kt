package com.dwan.composeexample.compose

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreenView() {
    val navController = rememberNavController()
    var actionBarTitle by rememberSaveable { mutableStateOf("Home") }

    LaunchedEffect(navController) {
        navController.currentBackStackEntryFlow.collect { backStackEntry ->
            actionBarTitle = getTitleByRoute(backStackEntry.destination.route.orEmpty())
        }
    }
    Scaffold(
        topBar = { TopAppBar(title = { Text(text = actionBarTitle) }) },
        bottomBar = { BottomBar(navController = navController) }
    ) {
        navigationGraph(navController = navController)
    }
}

fun getTitleByRoute(route: String): String {
    return when (route) {
        "home" -> "Home"
        "dashboard" -> "Dashboard"
        "notification" -> "Notifications"
        else -> ""
    }
}