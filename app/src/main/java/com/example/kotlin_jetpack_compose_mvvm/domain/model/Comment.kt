package com.example.kotlin_jetpack_compose_mvvm.domain.model

data class Comment (
    val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    val body: String
)