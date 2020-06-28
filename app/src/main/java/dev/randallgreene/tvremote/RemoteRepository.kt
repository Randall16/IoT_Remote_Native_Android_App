package dev.randallgreene.tvremote

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.annotation.WorkerThread
import java.lang.Exception

class RemoteRepository(application: Application) {

    private val userPreferences = application
        .getSharedPreferences(USER_PREFS, Context.MODE_PRIVATE)

    private val ipAddress: String
        get() = userPreferences.getString(IP_KEY, null) ?: "192.168.0.6"

    private val url: String
        get() = "http://$ipAddress:5000"

    private var remoteApi = createRemoteAPI(url)


    fun updateIpAddress(ip: String) {
        userPreferences.edit().putString(IP_KEY, ip).apply()
        remoteApi = createRemoteAPI(url)
    }

    @WorkerThread
    suspend fun sendButton(button: RemoteButton): Boolean {
        try {
            val s = remoteApi.sendButton(button.str).await()
            Log.i("reqer", s)
        } catch (exception: Exception) {
            return false
        }
        return true
    }
}