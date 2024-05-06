package com.example.minangkos.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.minangkos.R
import com.example.minangkos.ui.theme.Primary
import com.example.minangkos.util.ElipsisString
import com.example.minangkos.util.StringThousandSeparator

data class KosBedroom(
    val image: Int,
    val title: String,
    val kosType: String,
    val address: String,
    val facility: String,
    val rating: String,
    val promo: String,
    val price: Float
)

@Composable
fun CardKosBedroom() {
    val bedrooms = listOf(
        KosBedroom(
            image = R.drawable.bed1,
            title = "Kos Amanah",
            kosType = "Putra",
            address = "Aur Kuning",
            facility = "AC • Kamar Mandi Dalam • WIFI",
            rating = "5.0",
            promo = "Diskon 10%",
            price = 500_000f
        ),
        KosBedroom(
            image = R.drawable.bed2,
            title = "Kos Budi Santoso Bukittinggi Kita Sehat",
            kosType = "Campur",
            address = "Aur Kuning",
            facility = "AC • Kamar Mandi Dalam • WIFI",
            rating = "4.0",
            promo = "Diskon 10%",
            price = 700_000f
        ),
        KosBedroom(
            image = R.drawable.bed3,
            title = "Kos Amanah",
            kosType = "Putri",
            address = "Aur Kuning",
            facility = "AC • Kamar Mandi Dalam • WIFI • Parkiran",
            rating = "4.4",
            promo = "Diskon 10%",
            price = 800_000f
        ),
        KosBedroom(
            image = R.drawable.bed4,
            title = "Kos Budi Santoso Bukittinggi Kita Sehat",
            kosType = "Campur",
            address = "Aur Kuning",
            facility = "AC • Kamar Mandi Dalam • WIFI",
            rating = "4.1",
            promo = "Diskon 10%",
            price = 700_000f
        ),
        KosBedroom(
            image = R.drawable.bed5,
            title = "Kos Amanah",
            kosType = "Putri",
            address = "Aur Kuning",
            facility = "AC • Kamar Mandi Dalam • WIFI • Parkiran",
            rating = "4.4",
            promo = "Diskon 10%",
            price = 1_800_000f
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
            .height(355.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        border = BorderStroke(width = 1.dp, color = Color.LightGray)
    ) {
        Column {
            RowImageBedroom(image = kosBedroom.image)
            RowKosType(kosType = kosBedroom.kosType)
            RowTitle(title = kosBedroom.title)
            RowAddress(address = kosBedroom.address)
            RowFacility(facility = kosBedroom.facility)
            RowRating(rating = kosBedroom.rating)
            RowPromo(promo = kosBedroom.promo)
            RowPrice(price = kosBedroom.price)
        }
    }
}

@Composable
fun RowImageBedroom(image: Int) {
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .height(130.dp),
        painter = painterResource(id = image),
        contentDescription = "",
        contentScale = ContentScale.FillBounds
    )
}

@Composable
fun RowKosType(kosType: String) {
    Row(
        modifier = Modifier.padding(
            start = 10.dp,
            top = 10.dp
        )
    ) {
        BorderText(text = "Kos Andalan", paddingStart = 0.dp)
        BorderText(text = kosType, paddingStart = 8.dp)
    }
}

@Composable
fun RowTitle(title: String) {
    Text(
        modifier = Modifier
            .padding(start = 10.dp, top = 10.dp)
            .alpha(0.7f),
        text = ElipsisString(value = title, maxLength = 25),
        fontSize = 12.sp
    )
}

@Composable
fun RowAddress(address: String) {
    Row(
        modifier = Modifier.padding(
            start = 10.dp,
            top = 10.dp
        )
    ) {
        Icon(
            modifier = Modifier
                .size(18.dp)
                .alpha(0.7f),
            imageVector = Icons.Outlined.LocationOn,
            contentDescription = ""
        )
        Text(
            modifier = Modifier
                .alpha(0.7f)
                .padding(start = 5.dp),
            text = address,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun RowFacility(facility: String) {
    Text(
        modifier = Modifier
            .alpha(0.5f)
            .padding(start = 10.dp, top = 10.dp),
        text = ElipsisString(value = facility, maxLength = 25),
        fontSize = 12.sp
    )
}

@Composable
fun RowRating(rating: String) {
    Row(
        modifier = Modifier.padding(start = 10.dp, top = 10.dp)
    ) {
        Icon(
            modifier = Modifier
                .size(18.dp),
            imageVector = Icons.Filled.Star,
            contentDescription = "",
            tint = Primary
        )
        Text(
            modifier = Modifier
                .alpha(0.7f)
                .padding(start = 5.dp),
            text = rating,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun RowPromo(promo: String) {
    Row(
        modifier = Modifier.padding(start = 10.dp, top = 10.dp)
    ) {
        Icon(
            modifier = Modifier
                .size(18.dp),
            imageVector = Icons.Outlined.DateRange,
            contentDescription = "",
            tint = Primary
        )
        Text(
            modifier = Modifier
                .padding(start = 5.dp),
            text = promo,
            fontSize = 14.sp,
            color = Primary
        )
    }
}

@Composable
fun RowPrice(price: Float) {
    Row (
        modifier = Modifier.padding(start = 10.dp, top = 10.dp)
    ) {
        Text(
            modifier = Modifier
                .alpha(0.7f),
            text = "Rp${StringThousandSeparator(price)}",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier
                .alpha(0.7f),
            text = "/bulan",
            fontSize = 14.sp,
        )
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
                .padding(5.dp)
                .alpha(0.7f),
            text = text,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp
        )
    }
}