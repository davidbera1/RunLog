package com.db.analytics.data.di

import com.db.analytics.data.RoomAnalyticsRepository
import com.db.analytics.domain.AnalyticsRepository
import com.db.core.database.RunDatabase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val analyticsModule = module {
    singleOf(::RoomAnalyticsRepository).bind<AnalyticsRepository>()
    single {
        get<RunDatabase>().analyticsDao
    }
}