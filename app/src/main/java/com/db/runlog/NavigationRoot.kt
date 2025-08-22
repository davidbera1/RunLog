package com.db.runlog

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import androidx.navigation.navigation
import com.db.auth.presentation.intro.IntroScreenRoot
import com.db.auth.presentation.login.LoginScreenRoot
import com.db.auth.presentation.register.RegisterScreenRoot
import com.db.run.presentation.active_run.ActiveRunScreenRoot
import com.db.run.presentation.active_run.service.ActiveRunService
import com.db.run.presentation.run_overview.RunOverviewScreenRoot
import kotlinx.serialization.Serializable

@Composable
fun NavigationRoot(
    navController: NavHostController,
    isLoggedIn: Boolean
) {
    NavHost(
        navController = navController,
        startDestination = if (isLoggedIn) Run else Auth
    ) {
        authGraph(navController)
        runGraph(navController)
    }
}

private fun NavGraphBuilder.authGraph(navController: NavHostController) {
    navigation<Auth>(
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
                    navController.navigate(Run) {
                        popUpTo(Auth) {
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
    navigation<Run>(
        startDestination = RunOverviewRoute
    ) {
        composable<RunOverviewRoute> {
            RunOverviewScreenRoot(
                onStartRunClick = {
                    navController.navigate(ActiveRunRoute)
                }
            )
        }

        composable<ActiveRunRoute>(
            deepLinks = listOf(
                navDeepLink<ActiveRunRoute>(basePath = "runlog://active_run")
            )
        ) {
            val context = LocalContext.current
            ActiveRunScreenRoot(
                onBack =  {
                    navController.navigateUp()
                },
                onFinish = {
                    navController.navigateUp()
                },
                onServiceToggle = { shouldServiceRun ->
                    if (shouldServiceRun) {
                        context.startService(
                            ActiveRunService.createStartIntent(
                                context = context,
                                activityClass = MainActivity::class.java
                            )
                        )
                    } else {
                        context.startService(
                            ActiveRunService.createStopIntent(context = context)
                        )
                    }
                }
            )
        }
    }
}

@Serializable
data object Auth

@Serializable
data object IntroRoute

@Serializable
data object RegisterRoute

@Serializable
data object LoginRoute


@Serializable
data object Run

@Serializable
data object RunOverviewRoute

@Serializable
data object ActiveRunRoute
