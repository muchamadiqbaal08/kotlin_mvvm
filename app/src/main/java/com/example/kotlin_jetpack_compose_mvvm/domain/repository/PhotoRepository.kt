package com.example.kotlin_jetpack_compose_mvvm.domain.repository

import com.example.kotlin_jetpack_compose_mvvm.domain.model.Photo

interface PhotoRepository {
    suspend fun getPhotos() : List<Photo>
}