package com.example.kotlin_jetpack_compose_mvvm.di

import com.example.kotlin_jetpack_compose_mvvm.data.repository.CommentRepositoryImpl
import com.example.kotlin_jetpack_compose_mvvm.data.repository.PhotoRepositoryImpl
import com.example.kotlin_jetpack_compose_mvvm.data.repository.PostRepositoryImpl
import com.example.kotlin_jetpack_compose_mvvm.domain.repository.CommentRepository
import com.example.kotlin_jetpack_compose_mvvm.domain.repository.PhotoRepository
import com.example.kotlin_jetpack_compose_mvvm.domain.repository.PostRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCommentRepository(
        impl: CommentRepositoryImpl
    ): CommentRepository

    @Binds
    @Singleton
    abstract fun bindPhotoRepository(
        impl: PhotoRepositoryImpl
    ) : PhotoRepository

    @Binds
    @Singleton
    abstract fun bindPostRepository(
        impl: PostRepositoryImpl
    ) : PostRepository
}