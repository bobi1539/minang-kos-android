package com.example.minangkos.graph

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.minangkos.Route
import com.example.minangkos.graph.screen.main.HomeScreen

@Composable
fun MainNavigationGraph(
    navController: NavHostController,
    contentPadding: PaddingValues,
) {
    NavHost(
        navController = navController,
        route = Graph.MAIN,
        startDestination = Route.HOME
    ) {
        composable(route = Route.HOME) {
            HomeScreen(contentPadding = contentPadding)
        }

        composable(route = Route.MY_KOS) {
            Text(text = "Hello my kos")
        }

        composable(route = Route.CHAT) {
            Text(text = "Hello chat")
        }

        composable(route = Route.LOGIN) {
            Text(text = "Hello Login")
        }
    }
}