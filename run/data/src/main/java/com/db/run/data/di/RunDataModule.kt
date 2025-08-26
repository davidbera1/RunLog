package com.db.run.data.di

import com.db.core.domain.run.SyncRunScheduler
import com.db.run.data.CreateRunWorker
import com.db.run.data.DeleteRunWorker
import com.db.run.data.FetchRunsWorker
import com.db.run.data.SyncRunWorkerScheduler
import org.koin.androidx.workmanager.dsl.workerOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val runDataModule = module {
    workerOf(::CreateRunWorker)
    workerOf(::FetchRunsWorker)
    workerOf(::DeleteRunWorker)

    singleOf(::SyncRunWorkerScheduler).bind<SyncRunScheduler>()
}