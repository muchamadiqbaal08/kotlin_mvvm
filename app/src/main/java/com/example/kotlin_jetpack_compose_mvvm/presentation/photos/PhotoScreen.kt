package com.example.kotlin_jetpack_compose_mvvm.presentation.photos

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.kotlin_jetpack_compose_mvvm.R
import com.example.kotlin_jetpack_compose_mvvm.domain.model.Photo

@Composable
fun PhotoScreen() {
    val viewModel: PhotoViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsState()

    when (uiState) {
        is PhotoUiState.Loading -> {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        is PhotoUiState.Success -> {
            PhotoList((uiState as PhotoUiState.Success).photos)
        }
        is PhotoUiState.Error -> {
            Text("Error: ${(uiState as PhotoUiState.Error).message}")
        }
    }
}

@Composable
fun PhotoList(photos: List<Photo>) {
    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        items(photos) { photo ->
            Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    AsyncImage(
                        model = photo.url,
                        contentDescription = "Network Image",
                        error = painterResource(id = R.drawable.image_not_found),
                        modifier = Modifier.size(
                            width = 150.dp,
                            height = 200.dp
                        )
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = photo.title,
                        style = MaterialTheme.typography.titleMedium,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}