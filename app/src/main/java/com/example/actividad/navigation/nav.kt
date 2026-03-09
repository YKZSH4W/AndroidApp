package com.example.actividad.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.actividad.Screens.LogInMenu
import com.example.actividad.Screens.SignUpMenu
import com.example.actividad.Screens.WelcomeMenu

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "welcome"
    ) {
        composable("welcome") {
            WelcomeMenu(navController)
        }

        composable("login") {
            LogInMenu(navController)
        }

        composable("signup") {
            SignUpMenu(navController)
        }
    }
}