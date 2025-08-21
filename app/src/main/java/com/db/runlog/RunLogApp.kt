package com.db.runlog

import android.app.Application
import com.db.auth.data.di.authDataModule
import com.db.auth.presentation.di.authViewModelModule
import com.db.core.data.di.coreDataModule
import com.db.core.database.di.databaseModule
import com.db.run.location.di.locationModule
import com.db.run.presentation.di.runPresentationModule
import com.db.runlog.di.appModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class RunLogApp : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidLogger()
            androidContext(this@RunLogApp)
            modules(
                authDataModule,
                authViewModelModule,
                appModule,
                coreDataModule,
                runPresentationModule,
                locationModule,
                databaseModule
            )
        }
    }
}