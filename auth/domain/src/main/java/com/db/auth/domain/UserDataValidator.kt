package com.db.auth.domain

class UserDataValidator(
    private val patternValidator: PatternValidator
) {

    fun isValidEmail(email: String): Boolean {
        return patternValidator.matches(email.trim())
    }

    companion object {
        const val MIN_PASSWORD_LENGTH = 9
    }
}