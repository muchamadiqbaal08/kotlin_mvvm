package com.example.kotlin_jetpack_compose_mvvm.domain.usecase

import com.example.kotlin_jetpack_compose_mvvm.domain.model.Comment
import com.example.kotlin_jetpack_compose_mvvm.domain.repository.CommentRepository

class GetCommentsUseCase(private val repository: CommentRepository) {
    suspend operator fun invoke() : List<Comment> = repository.getComments()
}