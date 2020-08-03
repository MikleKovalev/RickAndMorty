package com.example.rickandmorty.platform.di

import com.example.rickandmorty.BuildConfig
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val TIMEOUT: Long = 30

val networkModule = module {
    single { buildJson() }
    single { buildOkHttp() }
    single { buildRetrofit(get(), get()) }
}

private fun buildJson() = GsonBuilder().create()

private fun buildOkHttp(): OkHttpClient {
    val okHttpClientBuilder = OkHttpClient.Builder()
    okHttpClientBuilder.apply {
        connectTimeout(TIMEOUT, TimeUnit.SECONDS)
        readTimeout(TIMEOUT, TimeUnit.SECONDS)
        if (BuildConfig.DEBUG) {
            addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        }
    }
    return okHttpClientBuilder.build()
}

private fun buildRetrofit(client: OkHttpClient, gson: Gson): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BuildConfig.API_ENDPOINT)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
}