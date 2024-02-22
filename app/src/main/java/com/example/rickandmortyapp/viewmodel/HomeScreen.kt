/**
 * James Hamilton
 * February 22nd, 2024
 * ADEV 3007: Zacharie Montreuil
 */

package com.example.rickandmortyapp.viewmodel

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import com.example.rickandmortyapp.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.Alignment
import com.example.rickandmortyapp.network.RMCharacter
import coil.compose.AsyncImage
import coil.request.ImageRequest
import androidx.compose.ui.platform.LocalContext
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color


@Composable
fun HomeScreen(
    rmUiState: RMUiState,
    modifier: Modifier = Modifier
) {
    when (rmUiState) {
        is RMUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is RMUiState.Success -> {
            LazyColumn(modifier = modifier) {
                items(rmUiState.characters) { character ->
                    RMPhotoCard(character = character)

                }
            }
        }
        is RMUiState.Error -> ErrorScreen(modifier = modifier.fillMaxSize())
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(R.drawable.loading_img),
        contentDescription = "Loading"
    )
}

@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_connection_error), contentDescription = ""
        )
        Text(text = "Loading Failed", modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun RMPhotoCard(character: RMCharacter, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp)
            .border(2.dp, Color.Black, RoundedCornerShape(6.dp))
            .background(Color.LightGray, shape = RoundedCornerShape(6.dp))
            .padding(4.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(character.image)
                .crossfade(true)
                .build(),
            contentDescription = "RM Image",
            error = painterResource(R.drawable.ic_broken_image),
            placeholder = painterResource(R.drawable.loading_img),
            modifier = Modifier
                .size(100.dp)
                .padding(8.dp)
        )
        Column(modifier = Modifier.padding(2.dp)) {
            Text(
                text = character.name
            )
            Text(
                text = "Species: ${character.species}"
            )
            Text(
                text = "Gender: ${character.gender}"
            )
            Text(
                text = "Origin: ${character.origin.name}"
            )
        }
    }
}








