package com.example.kotlin_jetpack_compose_mvvm.data.repository

import com.example.kotlin_jetpack_compose_mvvm.data.remote.ApiServices
import com.example.kotlin_jetpack_compose_mvvm.domain.model.Post
import com.example.kotlin_jetpack_compose_mvvm.domain.repository.PostRepository
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(private val api: ApiServices) : PostRepository {
    override suspend fun getPosts(): List<Post> {
        return api.getPosts().map {
            Post(
                id = it.id,
                title = it.title,
                body = it.body
            )
        }
    }
}