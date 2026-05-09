package com.oceanentp.shreets_assignment.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.oceanentp.shreets_assignment.ui.screens.DashboardScreen
import com.oceanentp.shreets_assignment.ui.screens.LoginScreen
import com.oceanentp.shreets_assignment.ui.screens.SetPasswordScreen
import com.oceanentp.shreets_assignment.ui.screens.WelcomeScreen

sealed class Screen(val route: String) {
    object Welcome : Screen("welcome")
    object SetPassword : Screen("set_password")
    object Login : Screen("login")
    object Dashboard : Screen("dashboard")
}

@Composable
fun AppNavigation(innerPadding: PaddingValues) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Welcome.route) {
        composable(Screen.Welcome.route) {
            WelcomeScreen(
                onNavigateNext = { navController.navigate(Screen.SetPassword.route) }
            )
        }
        composable(Screen.SetPassword.route) {
            SetPasswordScreen(
                onSaveClicked = { navController.navigate(Screen.Login.route) }
            )
        }
        composable(Screen.Login.route) {
            LoginScreen(
                onUnlock = { navController.navigate(Screen.Dashboard.route) {
                    // Pop up to clear the backstack so user can't go back to login
                    popUpTo(Screen.Welcome.route) { inclusive = true }
                } }
            )
        }
        composable(Screen.Dashboard.route) {
            DashboardScreen()
        }
    }
}