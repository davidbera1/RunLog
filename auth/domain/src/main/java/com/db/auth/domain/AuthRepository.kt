package com.db.auth.domain

import com.db.core.domain.util.DataError
import com.db.core.domain.util.EmptyResult

interface AuthRepository {
    suspend fun register(email: String, password: String): EmptyResult<DataError.Network>
}