package com.example.edusearch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.edusearch.ui.theme.EduSearchTheme
import com.example.edusearch.view.PerfilScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EduSearchTheme {
                PerfilScreen()
            }
        }
    }
}