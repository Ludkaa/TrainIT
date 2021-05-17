package com.example.trainit.data

import android.os.NetworkOnMainThreadException
import android.os.StrictMode
import android.security.keystore.UserNotAuthenticatedException
import android.util.Log
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import java.io.IOException


/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    fun login(username: String, password: String): Result<String> {
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        val json = """
        {
            "login":"$username",
            "heslo":"$password"
        }
        """.trimIndent()
        val okHttpClient = OkHttpClient()
        val body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json)
        val request = Request.Builder()
                .url("https://dbtspapi.herokuapp.com/adminlogin")
                .post(body)
                .build()
        val response = okHttpClient.newCall(request).execute()
        Log.d("resp", response.code().toString())
        return if (response.code() == 200) {
            Result.Success("$username")
        } else {
            Result.Error(IOException("Error logging in"))
        }


    }

    fun logout() {
        // TODO: revoke authentication
    }
}