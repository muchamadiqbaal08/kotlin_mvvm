package com.example.kotlin_jetpack_compose_mvvm.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kotlin_jetpack_compose_mvvm.presentation.MainScreen
import com.example.kotlin_jetpack_compose_mvvm.presentation.comments.CommentScreen
import com.example.kotlin_jetpack_compose_mvvm.presentation.photos.PhotoScreen
import com.example.kotlin_jetpack_compose_mvvm.presentation.posts.PostScreen

@Composable
fun AppNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Screen.Main.route
    ) {
        composable(Screen.Main.route) {
            MainScreen(navController = navController)
        }
        composable(Screen.Post.route) {
            PostScreen()
        }
        composable(Screen.Comment.route) {
            CommentScreen()
        }
        composable(Screen.Photo.route) {
            PhotoScreen()
        }
    }
}