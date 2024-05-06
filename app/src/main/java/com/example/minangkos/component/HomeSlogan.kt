package com.example.minangkos.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.minangkos.R

@Composable
fun HomeSlogan() {
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
    }
}