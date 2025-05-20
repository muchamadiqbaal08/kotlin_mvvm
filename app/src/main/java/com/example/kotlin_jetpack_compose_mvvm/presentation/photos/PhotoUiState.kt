package com.example.kotlin_jetpack_compose_mvvm.presentation.photos

import com.example.kotlin_jetpack_compose_mvvm.domain.model.Photo

sealed class PhotoUiState {
    data object Loading : PhotoUiState()
    data class Success(val photos: List<Photo>) : PhotoUiState()
    data class Error(val message: String) : PhotoUiState()


}