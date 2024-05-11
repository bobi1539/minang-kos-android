package com.example.minangkos.graph

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.minangkos.constant.Graph
import com.example.minangkos.screen.MainScreen

@Composable
fun RootNavGraph() {
    val rootNavController = rememberNavController()

    NavHost(
        navController = rootNavController,
        route = Graph.ROOT,
        startDestination = Graph.MAIN
    ) {
        composable(route = Graph.MAIN) {
            MainScreen(rootNavController = rootNavController)
        }
        detailNavGraph()
    }
}