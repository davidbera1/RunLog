package com.db.analytics.domain

interface AnalyticsRepository {
    suspend fun getAnalyticsValues(): AnalyticsValues
}