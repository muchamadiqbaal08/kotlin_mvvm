package com.example.kotlin_jetpack_compose_mvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.kotlin_jetpack_compose_mvvm.presentation.InitializeApps
import com.example.kotlin_jetpack_compose_mvvm.ui.theme.Kotlin_compose_mvvmTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Kotlin_compose_mvvmTheme {
                InitializeApps()
            }
        }
    }
}