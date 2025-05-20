package com.example.kotlin_jetpack_compose_mvvm.data.remote

import com.example.kotlin_jetpack_compose_mvvm.data.model.CommentDto
import com.example.kotlin_jetpack_compose_mvvm.data.model.PhotoDto
import com.example.kotlin_jetpack_compose_mvvm.data.model.PostDto
import retrofit2.http.GET

interface ApiServices {
    @GET("/posts")
    suspend fun getPosts(): List<PostDto>

    @GET("/comments")
    suspend fun getComments(): List<CommentDto>

    @GET("/photos")
    suspend fun  getPhotos() : List<PhotoDto>
}