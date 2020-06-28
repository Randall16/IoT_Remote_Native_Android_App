package dev.randallgreene.tvremote

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

class RemoteViewModel(application: Application) : AndroidViewModel(application) {

    private val remoteRepository = RemoteRepository(application)

    private val job = Job()
    private val viewModelScope = CoroutineScope(Dispatchers.IO + job)

    private val _requestSuccess = MutableLiveData<Boolean>()
    val requestSuccess: LiveData<Boolean> = _requestSuccess

    private val _requestFailure = MutableLiveData<Boolean>()
    val requestFailure: LiveData<Boolean> = _requestFailure


    fun updateIpAddress(ipAddress: String) {
        remoteRepository.updateIpAddress(ipAddress)
    }

    fun sendButton(remoteButton: RemoteButton) {
        viewModelScope.launch {
           val responseSuccess = remoteRepository.sendButton(remoteButton)

            if (responseSuccess) {
                val inverse = !(_requestSuccess.value ?: true)
                _requestSuccess.postValue(inverse)
            }
            else {
                val inverse = !(_requestFailure.value ?: true)
                _requestFailure.postValue(inverse)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}
