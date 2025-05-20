package com.example.kotlin_jetpack_compose_mvvm.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.kotlin_jetpack_compose_mvvm.ui.navigation.AppNavGraph

@Composable
fun InitializeApps() {
    val navController = rememberNavController()
    AppNavGraph(navController = navController)
}
