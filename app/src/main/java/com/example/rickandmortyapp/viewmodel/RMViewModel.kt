package com.example.rickandmortyapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.network.RMApi
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface RMUiState {
    data class Success(val characters: String) : RMUiState
    object Error : RMUiState
    object Loading : RMUiState
}

class RMViewModel : ViewModel() {
    /** The mutable State that stores the status of the most recent request */
    var rmUiState: RMUiState by mutableStateOf(RMUiState.Loading)
        private set

    /**
     * Call getMarsPhotos() on init so we can display status immediately.
     */
    init {
        getCharacters()
    }

    /**
     * Gets Mars photos information from the Mars API Retrofit service and updates the
     * [MarsPhoto] [List] [MutableList].
     */
    fun getCharacters() {
        viewModelScope.launch {
            rmUiState = try{
                val listResult = RMApi.retrofitService.getCharacters()
                RMUiState.Success(
                    "Success: ${listResult.size} characters retrieved!"
                )
            } catch (e: IOException) {
                RMUiState.Error
            }
        }
    }
}