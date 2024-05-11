package com.example.minangkos.graph.screen.main

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.minangkos.component.BottomNavigationBar
import com.example.minangkos.graph.MainNavigationGraph

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavHostController = rememberNavController()) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { contentPadding ->
        MainNavigationGraph(
            navController = navController,
            contentPadding = contentPadding
        )
    }
}
