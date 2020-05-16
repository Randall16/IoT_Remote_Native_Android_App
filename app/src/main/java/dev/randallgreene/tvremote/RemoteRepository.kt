package dev.randallgreene.tvremote

import androidx.annotation.WorkerThread
import retrofit2.HttpException
import java.lang.Exception

class RemoteRepository(url: String) {

    private var remoteApi = createRemoteAPI(url)

    @WorkerThread
    suspend fun sendButton(button: RemoteButton): String {
        var response: String?

        try {
            response = remoteApi.sendButton(button.str).await()
        } catch (ex: HttpException) {
            response = "HTTP ERROR"
        } catch (exception: Exception) {
            response = "ERROR"
        }

        return response ?: ""
    }

    fun updateURL(url: String) {
        remoteApi = createRemoteAPI(url)
    }
}