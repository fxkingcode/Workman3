package com.example.workman.Api

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.GsonBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ServiceGenerator(val context: Context) {
    private val BASE_URL = IPAdress.BaseURL

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val original = chain.request()

            val sp: SharedPreferences = context.getSharedPreferences("workman", 0)
            var token: String? = sp.getString("token", "empty")

            if (token == null) {
                token = "empty"
            }

            val requestBuilder = original.newBuilder()
                .header("token", token)
                .method(original.method(), original.body())

            val request = requestBuilder.build()
            chain.proceed(request)
        }.build()

    var gson = GsonBuilder()
        .setLenient()
        .create()

    val instance: Api by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()

        retrofit.create(Api::class.java)
    }
}