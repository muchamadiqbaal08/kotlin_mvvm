package com.example.kotlin_jetpack_compose_mvvm.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.kotlin_jetpack_compose_mvvm.ui.navigation.Screen

@Composable
fun MainScreen(navController: NavHostController) {

    val menus = listOf(
        "Posts",
        "Comments",
        "Photos",
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        menus.chunked(2).forEach { rowItems ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                rowItems.forEach { menu ->
                    Button(
                        modifier = Modifier
                            .weight(1f),
                        onClick = {
                            when (menu) {
                                "Posts" -> navController.navigate(Screen.Post.route)
                                "Comments" -> navController.navigate(Screen.Comment.route)
                                "Photos" -> navController.navigate(Screen.Photo.route)
                            }
                        }
                    ) {
                        Text(text = menu)
                    }
                }

                if (rowItems.size < 2) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}