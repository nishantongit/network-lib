package com.example.androidrnd.data.datasource.remote.api

import com.example.androidrnd.data.datasource.remote.service.EmployeeService
import com.nishant.network.network.NetworkResultCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class ApiClient {
    companion object {
        fun getService(): EmployeeService {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            val httpClientBuilder = OkHttpClient.Builder()
            httpClientBuilder.addInterceptor(logging)
            return Retrofit.Builder()
                .baseUrl("https://dummy.restapiexample.com/")
                .addConverterFactory(MoshiConverterFactory.create(
                    Moshi.Builder()
                        .addLast(KotlinJsonAdapterFactory())
                        .build())
                )
                .addCallAdapterFactory(NetworkResultCallAdapterFactory.create())
                .client(httpClientBuilder.build()).build()
                .create(EmployeeService::class.java)
        }
    }
}