package com.db.runlog

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.db.auth.presentation.intro.IntroScreenRoot
import com.db.auth.presentation.register.RegisterScreenRoot
import kotlinx.serialization.Serializable

@Composable
fun NavigationRoot(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = AuthRoute
    ) {
        authGraph(navController)
    }
}

private fun NavGraphBuilder.authGraph(navController: NavHostController) {
    navigation<AuthRoute>(
        startDestination = IntroRoute
    ) {
        composable<IntroRoute> {
            IntroScreenRoot(
                onSignUpClick = {
                    navController.navigate(RegisterRoute)
                },
                onSignInClick = {
                    navController.navigate(LoginRoute)
                }
            )
        }
        composable<RegisterRoute> {
            RegisterScreenRoot(
                onSignInClick = {
                    navController.navigate(LoginRoute) {
                        popUpTo(RegisterRoute) {
                            inclusive = true
                            saveState = true
                        }
                        restoreState = true
                    }
                },
                onSuccessfulRegistration = {
                    navController.navigate(LoginRoute)
                }
            )
        }
        composable<LoginRoute> {
            Text(text = "Login")
        }
    }
}

@Serializable
data object AuthRoute

@Serializable
data object IntroRoute

@Serializable
data object RegisterRoute

@Serializable
data object LoginRoute