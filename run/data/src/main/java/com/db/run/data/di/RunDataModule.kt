package com.db.run.data.di

import com.db.run.data.CreateRunWorker
import com.db.run.data.DeleteRunWorker
import com.db.run.data.FetchRunsWorker
import org.koin.androidx.workmanager.dsl.workerOf
import org.koin.dsl.module

val runDataModule = module {
    workerOf(::CreateRunWorker)
    workerOf(::FetchRunsWorker)
    workerOf(::DeleteRunWorker)
}