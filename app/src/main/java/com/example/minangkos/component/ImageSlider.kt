package com.example.minangkos.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.minangkos.R
import com.example.minangkos.ui.theme.Primary
import kotlinx.coroutines.delay

val images = listOf(
    R.drawable.cr3,
    R.drawable.cr7,
    R.drawable.cr2,
    R.drawable.cr4,
    R.drawable.cr5,
    R.drawable.cr6,
    R.drawable.cr1
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageSlider() {
    Column(
        modifier = Modifier.padding(
            horizontal = 15.dp,
            vertical = 20.dp
        )
    ) {
        val pagerState = rememberPagerState(initialPage = 0) {
            images.size
        }
        HorizontalPager(
            state = pagerState,
            key = { images[it] },
            pageSpacing = 10.dp
        ) { currentPage ->
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp)),
                painter = painterResource(id = images[currentPage]),
                contentDescription = "",
                contentScale = ContentScale.FillWidth
            )
        }

        Row(
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            images.forEachIndexed { index, _ ->
                Indicator(active = index == pagerState.currentPage)
                if (index < images.size - 1) {
                    Spacer(modifier = Modifier.width(10.dp))
                }
            }
        }

        LaunchedEffect(Unit) {
            while (true) {
                delay(5000)
//                        pagerState.scrollToPage(pagerState.currentPage + 1 % images.size)
                pagerState.animateScrollToPage((pagerState.currentPage + 1) % images.size)
            }
        }
    }
}

@Composable
fun Indicator(active: Boolean) {
    val color = if (active) Primary else Color.LightGray
    val size = 8.dp
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(color)
            .size(size)
    )
}