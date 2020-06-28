package dev.randallgreene.tvremote

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit


private const val TIME_OUT = 1500L

private val okHttpClient = OkHttpClient.Builder()
    .readTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
    .connectTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
    .build()

fun createRemoteAPI(ipAddress: String) = Retrofit.Builder()
    .baseUrl(ipAddress)
    .addConverterFactory(ScalarsConverterFactory.create())
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .client(okHttpClient)
    .build()
    .create(RemoteInterface::class.java)