package com.example.minangkos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.minangkos.graph.RootNavGraph
import com.example.minangkos.ui.theme.MinangkosandroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MinangkosandroidTheme {
                RootNavGraph()
            }
        }
    }
}

