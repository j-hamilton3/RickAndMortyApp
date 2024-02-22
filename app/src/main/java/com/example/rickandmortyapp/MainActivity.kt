/**
 * James Hamilton
 * February 22nd, 2024
 * ADEV 3007: Zacharie Montreuil
 */

package com.example.rickandmortyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.rickandmortyapp.ui.theme.RickAndMortyAppTheme
import com.example.rickandmortyapp.viewmodel.RMViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.rickandmortyapp.viewmodel.HomeScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickAndMortyAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val rmViewModel: RMViewModel = viewModel()
                    HomeScreen(
                        rmUiState = rmViewModel.rmUiState
                    )
                }
            }
        }
    }
}






