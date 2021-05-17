package com.example.trainit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.trainit.data.LoginRepository
import com.example.trainit.data.Result

/**
 * ViewModel pre login
 *
 * @property loginRepository
 * @constructor Create empty Login view model
 */
class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {
    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult

    /**
     * Login
     *
     * @param username
     * @param password
     */
    fun login(username: String, password: String) {
        // can be launched in a separate asynchronous job
        val result = loginRepository.login(username, password)

        if (result is Result.Success) {
            _loginResult.value = LoginResult(success = LoggedInUserView(displayName = result.data))
        } else {
            _loginResult.value = LoginResult(error = R.string.login_failed)
        }
    }
}