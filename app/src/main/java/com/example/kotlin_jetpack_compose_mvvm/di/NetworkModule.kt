package com.example.kotlin_jetpack_compose_mvvm.di

import com.example.kotlin_jetpack_compose_mvvm.data.remote.ApiServices
import com.example.kotlin_jetpack_compose_mvvm.data.repository.CommentRepositoryImpl
import com.example.kotlin_jetpack_compose_mvvm.data.repository.PhotoRepositoryImpl
import com.example.kotlin_jetpack_compose_mvvm.data.repository.PostRepositoryImpl
import com.example.kotlin_jetpack_compose_mvvm.domain.repository.CommentRepository
import com.example.kotlin_jetpack_compose_mvvm.domain.repository.PhotoRepository
import com.example.kotlin_jetpack_compose_mvvm.domain.repository.PostRepository
import com.example.kotlin_jetpack_compose_mvvm.domain.usecase.GetCommentsUseCase
import com.example.kotlin_jetpack_compose_mvvm.domain.usecase.GetPhotosUseCase
import com.example.kotlin_jetpack_compose_mvvm.domain.usecase.GetPostsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providePostApi(): ApiServices =
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiServices::class.java)

    @Provides
    @Singleton
    fun providePostRepository(api: ApiServices): PostRepository =
        PostRepositoryImpl(api)

    @Provides
    @Singleton
    fun provideCommentRepository(api: ApiServices): CommentRepository =
        CommentRepositoryImpl(api)

    @Provides
    @Singleton
    fun providePhotoRepository(api: ApiServices) : PhotoRepository = PhotoRepositoryImpl(api)

    @Provides
    @Singleton
    fun providePostUseCase(repository: PostRepository): GetPostsUseCase =
        GetPostsUseCase(repository)

    @Provides
    @Singleton
    fun provideCommentUseCase(repository: CommentRepository): GetCommentsUseCase =
        GetCommentsUseCase(repository)

    @Provides
    @Singleton
    fun providePhotoUseCase(repository: PhotoRepository) : GetPhotosUseCase =
        GetPhotosUseCase(repository)

}
