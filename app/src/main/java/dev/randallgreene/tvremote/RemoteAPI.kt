package dev.randallgreene.tvremote

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

fun createRemoteAPI(ipAddress: String) = Retrofit.Builder()
    .baseUrl(ipAddress)
    .addConverterFactory(ScalarsConverterFactory.create())
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .client(OkHttpClient())
    .build()
    .create(RemoteInterface::class.java)