package com.db.core.data.di

import com.db.core.data.auth.EncryptedSessionStorage
import com.db.core.data.networking.HttpClientFactory
import com.db.core.data.run.OfflineFirstRunRepository
import com.db.core.domain.SessionStorage
import com.db.core.domain.run.RunRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreDataModule = module {
    single {
        HttpClientFactory(get()).build()
    }
    singleOf(::EncryptedSessionStorage).bind<SessionStorage>()

    singleOf(::OfflineFirstRunRepository).bind<RunRepository>()
}