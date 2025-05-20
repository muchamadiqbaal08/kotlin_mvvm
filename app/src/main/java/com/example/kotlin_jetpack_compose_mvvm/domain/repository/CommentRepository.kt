package com.example.kotlin_jetpack_compose_mvvm.domain.repository

import com.example.kotlin_jetpack_compose_mvvm.domain.model.Comment

interface CommentRepository {
    suspend fun getComments() : List<Comment>
}