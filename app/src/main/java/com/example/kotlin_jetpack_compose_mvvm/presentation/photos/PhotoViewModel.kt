package com.example.kotlin_jetpack_compose_mvvm.presentation.photos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin_jetpack_compose_mvvm.domain.usecase.GetPhotosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotoViewModel @Inject constructor(
    private val getPhotosUseCase: GetPhotosUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<PhotoUiState>(PhotoUiState.Loading)
    val uiState : StateFlow<PhotoUiState> = _uiState

    init {
        getPhotos()
    }

    private fun getPhotos() {
        viewModelScope.launch {
            try {
                val photos = getPhotosUseCase()
                _uiState.value = PhotoUiState.Success(photos)
            } catch (e : Exception) {
                _uiState.value = PhotoUiState.Error("Failed to load photos")

            }
        }
    }
}