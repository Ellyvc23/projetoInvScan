package com.example.exibirpatrimoniosactivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.exibirpatrimoniosactivity.navigation.AppNavHost
import com.example.exibirpatrimoniosactivity.ui.theme.ExibirPatrimoniosActivityTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExibirPatrimoniosActivityTheme {
                AppNavHost()
            }
        }
    }
}
