package com.example.kotlin_jetpack_compose_mvvm.domain.usecase

import com.example.kotlin_jetpack_compose_mvvm.domain.model.Post
import com.example.kotlin_jetpack_compose_mvvm.domain.repository.PostRepository
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(private val repository: PostRepository) {
    suspend operator fun invoke(): List<Post> = repository.getPosts()
}