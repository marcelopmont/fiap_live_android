package com.ghostapps.androidexample.data

import com.ghostapps.androidexample.model.UserModel
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import java.lang.Exception

object UserHttp {
    const val BASE_URL = "https://run.mocky.io/v3/"

    fun loadUsers(): Array<UserModel> {
        val client = OkHttpClient.Builder().build()
        val request = Request.Builder().url("${BASE_URL}8418e7d6-1d40-421f-bd5f-9c072d2836f7").build()

        return try {
            val response = client.newCall(request).execute()
            val json = response.body()?.string()
            Gson().fromJson(json, Array<UserModel>::class.java)
        } catch (e: Exception) {
            e.printStackTrace()
            return arrayOf()
        }
    }
}