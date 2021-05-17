package com.example.trainit

/**
 * Vysledok autentifikacie
 *
 * @property success
 * @property error
 * @constructor Create empty Login result
 */
data class LoginResult (
     val success: LoggedInUserView? = null,
     val error:Int? = null
)