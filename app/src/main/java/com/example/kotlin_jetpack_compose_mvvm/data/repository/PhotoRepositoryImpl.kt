package com.example.kotlin_jetpack_compose_mvvm.data.repository

import com.example.kotlin_jetpack_compose_mvvm.data.remote.ApiServices
import com.example.kotlin_jetpack_compose_mvvm.domain.model.Photo
import com.example.kotlin_jetpack_compose_mvvm.domain.repository.PhotoRepository

class PhotoRepositoryImpl(private val api : ApiServices) : PhotoRepository {
    override suspend fun getPhotos() : List<Photo> {
        return api.getPhotos().map {
            Photo(
                id = it.id,
                title = it.title,
                url = it.url,
                thumbnailUrl = it.thumbnailUrl
            )
        }
    }
}