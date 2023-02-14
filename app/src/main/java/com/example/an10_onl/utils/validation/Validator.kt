package com.example.an10_onl.utils.validation

import android.util.Patterns
import com.example.an10_onl.R

fun validateFirstName(firstName: String): ValidationResult {
    return when {
        firstName.isBlank() -> {
            Invalid(R.string.firstName_blank)
        }
        firstName.length < 3 -> {
            Invalid(R.string.firstName_blank)
        }
        firstName.length > 255 -> {
            Invalid(R.string.firstName_blank)
        }
        else -> Valid
    }
}

fun validateLastName(lastName: String): ValidationResult {
    return when {
        lastName.isBlank() -> {
            Invalid(R.string.lastName_blank)
        }
        lastName.length < 3 -> {
            Invalid(R.string.lastName_blank)
        }
        lastName.length > 255 -> {
            Invalid(R.string.lastName_blank)
        }
        else -> Valid
    }
}

fun validatePassword(password: String): ValidationResult {
    return when {
        password.isBlank() -> {
            Invalid(R.string.password_blank)
        }
        password.length < 6 -> {
            Invalid(R.string.passwordLessThan6)
        }
        password.length > 50 -> {
            Invalid(R.string.passwordMoreThan50)
        }
        !password.matches(".*[A-Z].*".toRegex()) -> {
            Invalid(R.string.passwordUpperCase)
        }
        !password.matches(".*[a-z].*".toRegex()) -> {
            Invalid(R.string.passwordLowerCase)
        }
        !password.matches(".*[!@#$%^&*+=/?].*".toRegex()) -> {
            Invalid(R.string.passwordCharacter)
        }
        !password.matches(".*\\d.*".toRegex()) -> {
            Invalid(R.string.passwordDigit)
        }

        else -> Valid
    }
}

fun validateMessage(message: String): ValidationResult {
    return when {
        message.isBlank() -> {
            Invalid(R.string.firstName_blank)
        }
        else -> Valid
    }
}

fun validateTitle(title: String): ValidationResult {
    return when {
        title.isBlank() -> {
            Invalid(R.string.firstName_blank)
        }
        else -> Valid
    }
}

object EmailValidator {
    fun validateEmail(email: String): ValidationResult {
        return when {
            Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                Valid
            }
            email.isBlank() -> {
                Invalid(R.string.email_blank)
            }
            else -> Invalid(R.string.email_invalid)
        }
    }
}