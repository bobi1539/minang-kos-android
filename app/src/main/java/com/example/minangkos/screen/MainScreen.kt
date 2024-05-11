package com.example.minangkos.screen

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.minangkos.component.BottomNavigationBar
import com.example.minangkos.component.TopBar
import com.example.minangkos.graph.MainNavGraph

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(rootNavController: NavHostController) {
    val mainNavController = rememberNavController()
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomNavigationBar(navController = mainNavController) }
    ) { padding ->
        MainNavGraph(
            rootNavController = rootNavController,
            mainNavController = mainNavController,
            padding = padding
        )
    }
}