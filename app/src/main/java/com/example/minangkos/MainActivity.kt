package com.example.minangkos

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.minangkos.component.BottomNavigationBar
import com.example.minangkos.component.CardAllowNotification
import com.example.minangkos.component.CardKosBedroom
import com.example.minangkos.component.CardLoginKosOwner
import com.example.minangkos.component.CardSearchKos
import com.example.minangkos.component.DropdownSimple
import com.example.minangkos.component.HomeSlogan
import com.example.minangkos.component.ImageSlider
import com.example.minangkos.component.TopBar
import com.example.minangkos.graph.RootNavigationGraph
import com.example.minangkos.ui.theme.MinangkosandroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MinangkosandroidTheme {
                RootNavigationGraph(navHostController = rememberNavController())
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Home(modifier: Modifier = Modifier) {
    Scaffold(
        containerColor = Color.White,
        topBar = { TopBar() },
        bottomBar = { BottomNavigationBar(rememberNavController()) }
    ) { contentPadding ->
        val scrollState = rememberScrollState()

        Column(
            modifier
                .padding(contentPadding)
                .fillMaxSize()
                .verticalScroll(scrollState)
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
            CardKosBedroom()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MinangkosandroidTheme {
        Home()
    }
}

