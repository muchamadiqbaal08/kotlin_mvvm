package com.example.kotlin_jetpack_compose_mvvm.presentation.posts

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.kotlin_jetpack_compose_mvvm.domain.model.Post

@Composable
fun PostScreen() {
    val viewModel: PostViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsState()

    when (uiState) {
        is PostUiState.Loading -> {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        is PostUiState.Success -> {
            PostList((uiState as PostUiState.Success).posts)
        }
        is PostUiState.Error -> {
            Text("Error: ${(uiState as PostUiState.Error).message}")
        }
    }
}

@Composable
fun PostList(posts: List<Post>) {
    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        items(posts) { post ->
            Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = post.title, style = MaterialTheme.typography.titleMedium)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = post.body)
                }
            }
        }
    }
}