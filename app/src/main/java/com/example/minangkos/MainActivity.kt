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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.minangkos.component.BottomNavigationBar
import com.example.minangkos.component.CardAllowNotification
import com.example.minangkos.component.CardSearchKos
import com.example.minangkos.component.DropdownSimple
import com.example.minangkos.component.ImageSlider
import com.example.minangkos.component.TopBar
import com.example.minangkos.ui.theme.MinangkosandroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MinangkosandroidTheme {
                Home()
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
        bottomBar = { BottomNavigationBar() }
    ) { contentPadding ->
        val scrollState = rememberScrollState()

        Column(
            modifier
                .padding(contentPadding)
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 15.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.slogan_1),
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 22.sp
                )
                Text(
                    text = stringResource(id = R.string.slogan_2),
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
                CardSearchKos()
            }
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

