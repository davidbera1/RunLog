package com.db.auth.data.di

import com.db.auth.data.EmailPatternValidator
import com.db.auth.domain.PatternValidator
import com.db.auth.domain.UserDataValidator
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val authDataModule = module {
    single<PatternValidator> {
        EmailPatternValidator
    }
    singleOf(::UserDataValidator)
}