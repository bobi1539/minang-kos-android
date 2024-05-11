package com.example.minangkos.graph

import androidx.compose.material3.Text
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.minangkos.constant.Graph
import com.example.minangkos.constant.Route
import com.example.minangkos.screen.DetailKosScreen

fun NavGraphBuilder.detailNavGraph() {
    navigation(
        route = Graph.DETAIL,
        startDestination = Route.DETAIL_KOS
    ) {
        composable(route = Route.DETAIL_KOS) {
            DetailKosScreen()
        }
    }
}