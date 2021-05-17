package com.example.trainit.data


/**
 * Trieda ktora reprezentuje loginRepository
 *
 * @property dataSource
 * @constructor Create empty Login repository
 */

class LoginRepository(val dataSource: LoginDataSource) {

    var user: String? = null
        private set

    /**
     * Login
     *
     * @param username
     * @param password
     * @return
     */
    fun login(username: String, password: String): Result<String> {
        val result = dataSource.login(username, password)

        if (result is Result.Success) {
            setLoggedInUser(result.data)
        }

        return result
    }

    private fun setLoggedInUser(loggedInUser: String) {
        this.user = loggedInUser
    }
}