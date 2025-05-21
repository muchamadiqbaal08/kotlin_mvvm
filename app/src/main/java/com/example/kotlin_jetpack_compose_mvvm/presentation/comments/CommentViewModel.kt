package com.example.kotlin_jetpack_compose_mvvm.presentation.comments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin_jetpack_compose_mvvm.domain.repository.CommentRepository
import com.example.kotlin_jetpack_compose_mvvm.domain.usecase.GetCommentsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CommentViewModel @Inject constructor(
    private val getCommentsUseCase: GetCommentsUseCase,
    private val commentRepository: CommentRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<CommentUiState>(CommentUiState.Loading)
    val uiState: StateFlow<CommentUiState> = _uiState

    init {
        fetchComments()
    }

    private fun fetchComments() {
        viewModelScope.launch {
            try {
                val comments = getCommentsUseCase()
                val comments2 = commentRepository.getComments()
                _uiState.value = CommentUiState.Success(comments)
            } catch (e: Exception) {
                _uiState.value = CommentUiState.Error("Failed to load comments")
            }
        }
    }

    // we can't add any business logic here,
    // view model just wanna know if the retrieving data is success or fail


}