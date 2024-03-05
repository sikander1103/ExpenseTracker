package com.example.momo.coordinators

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.momo.presentation.onborading.OnboardingScreen
import com.example.momo.presentation.splash.SplashScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.SplashScreen.route) {
        composable(Screen.SplashScreen.route) { SplashScreen(navController) }
        composable(
            Screen.OnboardingScreen.route
        ) { backStackEntry ->
            OnboardingScreen(navController)
        }
    }
}
object Screen {
    object SplashScreen {
        const val route = "SplashScreen"
    }
    object OnboardingScreen {
        const val route = "OnboardingScreen"

    }
}
