package dev.randallgreene.tvremote

import kotlinx.coroutines.Deferred
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface RemoteInterface {

    @POST("api/{button}")
    fun sendButton(
        @Path("button") button: String,
        @Header("x-api-key") apiKey: String = API_KEY
    ): Deferred<String>
}