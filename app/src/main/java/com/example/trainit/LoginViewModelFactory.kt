package com.example.trainit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.trainit.data.LoginDataSource
import com.example.trainit.data.LoginRepository

/**
 * Sluzi na inicializaciu viewModelu
 *
 * @constructor Create empty Login view model factory
 */
class LoginViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(
                loginRepository = LoginRepository(
                    dataSource = LoginDataSource()
                )
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}