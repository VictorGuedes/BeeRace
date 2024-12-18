package com.oligue.app.beerace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.oligue.app.beerace.navigation.AppNestedNavigation
import com.oligue.app.beerace.ui.theme.BeeRaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BeeRaceTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    AppNestedNavigation()
                }
            }
        }
    }
}