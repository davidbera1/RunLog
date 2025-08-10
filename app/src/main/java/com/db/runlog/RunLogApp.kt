package com.db.runlog

import android.app.Application
import com.db.auth.data.di.authDataModule
import com.db.auth.presentation.di.authViewModelModule
import com.db.core.data.di.coreDataModule
import com.db.runlog.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class RunLogApp : Application() {

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
                coreDataModule
            )
        }
    }
}