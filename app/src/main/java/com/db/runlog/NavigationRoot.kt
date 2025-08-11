package com.db.runlog

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.db.auth.presentation.intro.IntroScreenRoot
import com.db.auth.presentation.login.LoginScreenRoot
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
        runGraph(navController)
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
            LoginScreenRoot(
                onLoginSuccess = {
                    navController.navigate(RunRoute) {
                        popUpTo(AuthRoute) {
                            inclusive = true
                        }
                    }
                },
                onSignUpClick = {
                    navController.navigate(RegisterRoute) {
                        popUpTo(LoginRoute) {
                            inclusive = true
                            saveState = true
                        }
                        restoreState = true
                    }
                }
            )
        }
    }
}

private fun NavGraphBuilder.runGraph(navController: NavHostController) {
    navigation<RunRoute>(
        startDestination = RunOverviewRoute
    ) {
        composable<RunOverviewRoute> {
            Text("Run Overview Screen")
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

@Serializable
data object RunRoute

@Serializable
data object RunOverviewRoute