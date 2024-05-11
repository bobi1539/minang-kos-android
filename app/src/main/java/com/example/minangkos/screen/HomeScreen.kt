package com.example.minangkos.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.minangkos.component.CardAllowNotification
import com.example.minangkos.component.CardKosBedroom
import com.example.minangkos.component.CardLoginKosOwner
import com.example.minangkos.component.CardSearchKos
import com.example.minangkos.component.DropdownSimple
import com.example.minangkos.component.HomeSlogan
import com.example.minangkos.component.ImageSlider

@Composable
fun HomeScreen(
    padding: PaddingValues,
    rootNavController: NavHostController,
) {
    Column(
        modifier = Modifier
            .padding(padding)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        HomeSlogan()
        CardSearchKos()
        CardLoginKosOwner()
        ImageSlider()
        CardAllowNotification()
        DropdownSimple(
            list = listOf(
                "Semua Kota",
                "Bukittinggi",
                "Padang",
                "Pekanbaru",
                "Medan",
                "Agam"
            ),
            true
        )
        CardKosBedroom(rootNavController = rootNavController)
    }
}