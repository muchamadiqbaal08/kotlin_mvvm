package com.example.kotlin_jetpack_compose_mvvm.domain.repository

import com.example.kotlin_jetpack_compose_mvvm.domain.model.Post

interface PostRepository {
    suspend fun getPosts(): List<Post>
}