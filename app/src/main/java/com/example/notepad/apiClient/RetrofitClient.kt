package com.example.notepad.apiClient

import com.example.notepad.interfaces.EndUrl
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class RetrofitClient {
    private var retrofit: Retrofit? = null
    private val BASE_URL: String = "https://3xs79s0rob.execute-api.us-west-1.amazonaws.com/dev/notes/"
    private var loggingInterceptor: HttpLoggingInterceptor? = null

   fun getApiClient(encrypt:Boolean,decrypt:Boolean):EndUrl?{
       getLoggingInterceptor()
       val builder: OkHttpClient.Builder = getOkHttpBuilder()
       loggingInterceptor?.let { builder.addNetworkInterceptor(it) }
       if (encrypt) {
           builder.addInterceptor(EncryptionClass())
       }
       if (decrypt) {
          // builder.addInterceptor(DecryptionInterceptor(OmnicureApp().getAppContext()))
       }
       addInterceptors(builder)

         getRetrofit(builder)
    return retrofit?.create(EndUrl::class.java)
   }

    private fun addInterceptors(builder: OkHttpClient.Builder) {
        loggingInterceptor?.let { builder.addNetworkInterceptor(it).build() }
    }

    private fun getOkHttpBuilder(): OkHttpClient.Builder {
        return OkHttpClient.Builder()
            .callTimeout(5, TimeUnit.MINUTES)
            .connectTimeout(5, TimeUnit.MINUTES)
            .readTimeout(5, TimeUnit.MINUTES)
            .writeTimeout(5, TimeUnit.MINUTES)
            .retryOnConnectionFailure(true)
    }

    private fun getLoggingInterceptor() {
        if (loggingInterceptor == null) {
            loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor!!.setLevel(HttpLoggingInterceptor.Level.BODY)
        }
    }

    private fun getRetrofit(builder: OkHttpClient.Builder) {
//        val encrypt=EncryptionClass()
//
//
//        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
//        val okHttpclient = OkHttpClient.Builder().addNetworkInterceptor(interceptor).build()
//        retrofit =  Retrofit.Builder()
//                .baseUrl(BASE_URL)
//               .client(okHttpclient)
//               .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
//               .build()
        val gson = GsonBuilder()
            .setLenient()
            .create()
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(builder.build())
            .build()
    }
}