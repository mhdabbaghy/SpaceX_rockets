package com.mhd.spacexrockets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.mhd.core_designsystem.theme.SpaceXRocketsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpaceXRocketsTheme {
                Greeting()
            }
        }
    }
}

@Composable
fun Greeting() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = "Hello Compose", modifier = Modifier.align(Alignment.Center))
    }
}