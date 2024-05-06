package com.example.minangkos

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
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
                    modifier = Modifier.alpha(0.8f),
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
            RowCard()

        }
    }
}

data class KosBedroom(
    val image: Int,
    val title: String,
    val kosType: String,
    val address: String,
    val facility: String,
    val price: Float
)

@Composable
fun RowCard() {
    val bedrooms = listOf(
        KosBedroom(
            image = R.drawable.bed1,
            title = "Kos Amanah",
            kosType = "Putra",
            address = "Aur Kuning",
            facility = "AC . Kamar Mandi Dalam . WIFI",
            price = 500_000f
        ),
        KosBedroom(
            image = R.drawable.bed2,
            title = "Kos Budi Santoso Bukittinggi Kita Sehat",
            kosType = "Campur",
            address = "Aur Kuning",
            facility = "AC . Kamar Mandi Dalam . WIFI",
            price = 700_000f
        ),
        KosBedroom(
            image = R.drawable.bed3,
            title = "Kos Amanah",
            kosType = "Putri",
            address = "Aur Kuning",
            facility = "AC . Kamar Mandi Dalam . WIFI . Parkiran",
            price = 800_000f
        ),
        KosBedroom(
            image = R.drawable.bed4,
            title = "Kos Budi Santoso Bukittinggi Kita Sehat",
            kosType = "Campur",
            address = "Aur Kuning",
            facility = "AC . Kamar Mandi Dalam . WIFI",
            price = 700_000f
        ),
        KosBedroom(
            image = R.drawable.bed5,
            title = "Kos Amanah",
            kosType = "Putri",
            address = "Aur Kuning",
            facility = "AC . Kamar Mandi Dalam . WIFI . Parkiran",
            price = 800_000f
        )
    )

    val isLastItem = remember {
        mutableStateOf(false)
    }
    LazyRow {
        itemsIndexed(items = bedrooms) { index, item ->
            isLastItem.value = index == bedrooms.size - 1
            RowItem(kosBedroom = item, isLastItem = isLastItem.value)
        }
    }
}

@Composable
fun RowItem(kosBedroom: KosBedroom, isLastItem: Boolean) {
    Card(
        modifier = Modifier
            .padding(
                start = 15.dp,
                end = if (isLastItem) 15.dp else 0.dp
            )
            .width(200.dp)
            .height(300.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        border = BorderStroke(width = 1.dp, color = Color.LightGray)
    ) {
        Column {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp),
                painter = painterResource(id = kosBedroom.image),
                contentDescription = "",
                contentScale = ContentScale.FillBounds
            )
            Row(
                modifier = Modifier.padding(
                    start = 10.dp,
                    top = 10.dp,
                    bottom = 5.dp
                )
            ) {
                BorderText(text = "Kos Andalan", 0.dp)
                BorderText(text = kosBedroom.kosType, 8.dp)
            }

            val kosTitle = if (kosBedroom.title.length > 20) {
                kosBedroom.title.substring(0, 20) + "..."
            } else {
                kosBedroom.title
            }

            Text(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .alpha(0.7f),
                text = kosTitle,
                fontSize = 12.sp,
                letterSpacing = 0.1.sp
            )
        }
    }
}

@Composable
fun BorderText(text: String, paddingStart: Dp) {
    Card(
        modifier = Modifier.padding(start = paddingStart),
        shape = RoundedCornerShape(5.dp),
        border = BorderStroke(width = 1.dp, color = Color.LightGray),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
    ) {
        Text(
            modifier = Modifier
                .padding(6.dp)
                .alpha(0.7f),
            text = text,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            letterSpacing = 0.1.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MinangkosandroidTheme {
        Home()
    }
}

