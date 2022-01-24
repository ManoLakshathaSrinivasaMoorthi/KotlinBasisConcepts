package com.example.notepad.apiClient

import com.example.notepad.interfaces.EndUrl
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class RetrofitClient {
    private var retrofit: Retrofit? = null
    private val BASE_URL: String = "https://3xs79s0rob.execute-api.us-west-1.amazonaws.com"
/*
//    companion object {
//
//
//        private const val BASE_URL: String = "https://3xs79s0rob.execute-api.us-west-1.amazonaws.com"
//        private val interceptor = HttpLoggingInterceptor().apply {
//            this.level = HttpLoggingInterceptor.Level.BODY
//        }
//        private val client = OkHttpClient.Builder().apply {
//            this.addInterceptor(interceptor )
//                .connectTimeout(30, TimeUnit.SECONDS)
//                .readTimeout(20, TimeUnit.SECONDS)
//                .writeTimeout(25, TimeUnit.SECONDS)
//
//        }.build()
//
//
//
//        fun getretrofit(): Retrofit {
//            return Retrofit.Builder()
//                .baseUrl(BASE_URL)
////                .client(client)
//                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
//                .build()
//        }
//
//
//    }

*/
   fun getApiClient():EndUrl?{
         getRetrofit()
    return retrofit!!.create(EndUrl::class.java)
   }

    private fun getRetrofit() {
        retrofit =  Retrofit.Builder()
                .baseUrl(BASE_URL)
//               .client(client)
               .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
               .build()
    }
}