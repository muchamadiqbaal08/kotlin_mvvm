package com.example.kotlin_jetpack_compose_mvvm.presentation.posts

import com.example.kotlin_jetpack_compose_mvvm.domain.model.Post

sealed class PostUiState {
    data object Loading : PostUiState()
    data class Success(val posts: List<Post>) : PostUiState()
    data class Error(val message: String) : PostUiState()
}