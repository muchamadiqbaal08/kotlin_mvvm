package com.example.kotlin_jetpack_compose_mvvm.ui.navigation

sealed class Screen(val route: String) {
    data object Main : Screen("main_screen")
    data object Post : Screen("post_screen")
    data object Comment : Screen("comment_screen")
    data object Photo : Screen("photo_screen")
}