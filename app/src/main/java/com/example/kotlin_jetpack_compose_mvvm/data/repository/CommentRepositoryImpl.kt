package com.example.kotlin_jetpack_compose_mvvm.data.repository

import com.example.kotlin_jetpack_compose_mvvm.data.remote.ApiServices
import com.example.kotlin_jetpack_compose_mvvm.domain.model.Comment
import com.example.kotlin_jetpack_compose_mvvm.domain.repository.CommentRepository
import javax.inject.Inject

class CommentRepositoryImpl @Inject constructor(private val api: ApiServices) : CommentRepository {
    override suspend fun getComments(): List<Comment> {
        return api.getComments().map {
            Comment(
                id = it.id,
                body = it.body,
                name = it.name,
                email = it.email,
            )
        }
    }
}