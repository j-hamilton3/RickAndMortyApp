/**
 * James Hamilton
 * February 22nd, 2024
 * ADEV 3007: Zacharie Montreuil
 */

package com.example.rickandmortyapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.network.RMApi
import com.example.rickandmortyapp.network.RMCharacter
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface RMUiState {
    data class Success(val characters: List<RMCharacter>) : RMUiState
    object Error : RMUiState
    object Loading : RMUiState
}

class RMViewModel : ViewModel() {
    var rmUiState: RMUiState by mutableStateOf(RMUiState.Loading)
        private set


    init {
        getCharacters()
    }

    fun getCharacters() {
        viewModelScope.launch {
            rmUiState = try{
                RMUiState.Success(RMApi.retrofitService.getCharacters())
            } catch (e: IOException) {
                RMUiState.Error
            }
        }
    }
}