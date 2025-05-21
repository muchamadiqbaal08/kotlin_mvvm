package com.example.kotlin_jetpack_compose_mvvm.domain.usecase

import com.example.kotlin_jetpack_compose_mvvm.domain.model.Photo
import com.example.kotlin_jetpack_compose_mvvm.domain.repository.PhotoRepository
import javax.inject.Inject

class GetPhotosUseCase @Inject constructor(private val repository: PhotoRepository) {
    suspend operator fun invoke(): List<Photo> = repository.getPhotos()
}