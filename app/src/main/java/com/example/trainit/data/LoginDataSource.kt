package com.example.trainit.data

import android.os.StrictMode
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import java.io.IOException


/**
 * Trieda ktora zabezpeci autentifikaciu a obdrzi informacie o pouzivatelovi
 *
 */
class LoginDataSource {

    /**
     *
     * @param username
     * @param password
     * @return
     */
    fun login(username: String, password: String): Result<String> {
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        val json = """
        {
            "login":"$username",
            "heslo":"$password"
        }
        """.trimIndent()

        //pomocou kniznice okhttp je vytvorenie spojenie potrebne na POST request
        val okHttpClient = OkHttpClient()
        val body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json)
        val request = Request.Builder()
                //url externeho api na heroku serveri (pouzite z VAII semestralky)
                .url("https://dbtspapi.herokuapp.com/adminlogin")
                .post(body)
                .build()
        val response = okHttpClient.newCall(request).execute()
        //Log.d("resp", response.code().toString())
        return if (response.code() == 200) {
            Result.Success("$username")
        } else {
            Result.Error(IOException("Error logging in"))
        }
    }
}