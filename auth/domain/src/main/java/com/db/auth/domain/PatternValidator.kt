package com.db.auth.domain

interface PatternValidator {
    fun matches(value: String): Boolean
}