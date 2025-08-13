package com.db.core.domain.location

import kotlin.time.Duration

data class LocationTimestamp(
    val location: Location,
    val durationTimestamp: Duration
)
