package com.example.kotlin_jetpack_compose_mvvm.data.model

data class CommentDto(
    val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    val body: String
)