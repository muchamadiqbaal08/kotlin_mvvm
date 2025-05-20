package com.example.kotlin_jetpack_compose_mvvm.presentation.comments

import com.example.kotlin_jetpack_compose_mvvm.domain.model.Comment

sealed class CommentUiState {
    data object Loading : CommentUiState()
    data class Success(val comments: List<Comment>) : CommentUiState()
    data class Error(val message: String) : CommentUiState()
}