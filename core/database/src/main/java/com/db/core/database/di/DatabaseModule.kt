package com.db.core.database.di

import androidx.room.Room
import com.db.core.database.RoomLocalRunDataSource
import com.db.core.database.RunDatabase
import com.db.core.domain.run.LocalRunDataSource
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            RunDatabase::class.java,
            "run.db"
        ).build()
    }

    single { get<RunDatabase>().runDao }
    single { get<RunDatabase>().runPendingSyncDao }

    singleOf(::RoomLocalRunDataSource).bind<LocalRunDataSource>()
}