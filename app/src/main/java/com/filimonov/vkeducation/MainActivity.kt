package com.filimonov.vkeducation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.filimonov.vkeducation.presentation.navigation.AppNavHost
import com.filimonov.vkeducation.presentation.ui.theme.VkEducationTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VkEducationTheme {
                AppNavHost()
            }
        }
    }
}
