package com.example.notepad.apiClient

import com.example.notepad.interfaces.EndUrl
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitClient {
    private var retrofit: Retrofit? = null
    private val BASE_URL: String = "https://3xs79s0rob.execute-api.us-west-1.amazonaws.com/dev/notes/"

   fun getApiClient():EndUrl?{
         getRetrofit()
    return retrofit?.create(EndUrl::class.java)
   }

    private fun getRetrofit() {
        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        val okHttpclient = OkHttpClient.Builder().addNetworkInterceptor(interceptor).build()
        retrofit =  Retrofit.Builder()
                .baseUrl(BASE_URL)
               .client(okHttpclient)
               .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
               .build()
    }
}