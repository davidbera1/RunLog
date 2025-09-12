package com.db.analytics.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.db.analytics.domain.AnalyticsRepository
import com.db.analytics.presentation.mapper.toAnalyticsDashboardState
import kotlinx.coroutines.launch

class AnalyticsDashboardViewModel(
    private val analyticsRepository: AnalyticsRepository
) : ViewModel() {

    var state by mutableStateOf<AnalyticsDashboardState?>(null)
        private set

    init {
        viewModelScope.launch {
            state = analyticsRepository.getAnalyticsValues().toAnalyticsDashboardState()
        }
    }
}