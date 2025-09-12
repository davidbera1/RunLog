package com.db.analytics.analytics_feature

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.db.analytics.data.di.analyticsModule
import com.db.analytics.presentation.AnalyticsDashboardScreenRoot
import com.db.analytics.presentation.di.analyticsPresentationModule
import com.db.core.presentation.designsystem.RunLogTheme
import com.db.runlog.AnalyticsDashboard
import com.google.android.play.core.splitcompat.SplitCompat
import org.koin.core.context.loadKoinModules

class AnalyticsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loadKoinModules(
            listOf(
                analyticsModule,
                analyticsPresentationModule
            )
        )

        SplitCompat.installActivity(this)

        setContent {
            RunLogTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = AnalyticsDashboard
                ) {
                    composable<AnalyticsDashboard> {
                        AnalyticsDashboardScreenRoot(
                            onBackClick = { finish() }
                        )
                    }
                }
            }
        }
    }
}