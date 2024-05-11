package com.example.minangkos.graph

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.minangkos.constant.Graph
import com.example.minangkos.constant.Route
import com.example.minangkos.screen.HomeScreen

@Composable
fun MainNavGraph(
    rootNavController: NavHostController,
    mainNavController: NavHostController,
    padding: PaddingValues
) {
    NavHost(
        navController = mainNavController,
        route = Graph.MAIN,
        startDestination = Route.HOME
    ) {
        composable(route = Route.HOME) {
            HomeScreen(
                padding = padding,
                rootNavController = rootNavController
            )
        }
        composable(route = Route.MY_KOS) {
            Text(
                modifier = Modifier.padding(padding),
                text = "HEllo My KOS"
            )
        }
        composable(route = Route.CHAT) {
            Text(
                modifier = Modifier.padding(padding),
                text = "Hello CHAT"
            )
        }
        composable(route = Route.LOGIN) {
            Text(
                modifier = Modifier.padding(padding),
                text = "Hello LOGIN"
            )
        }
    }
}