package com.example.minangkos.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.minangkos.ui.theme.Primary

@Composable
fun CardLoginKosOwner() {
    Card(
        modifier = Modifier.padding(
            start = 15.dp,
            end = 15.dp,
            top = 20.dp,
            bottom = 5.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Primary
        ),
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 15.dp,
                    end = 8.dp,
                    top = 5.dp,
                    bottom = 5.dp
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Anda Pemilik Kos?", color = Color.White)
            OutlinedButton(
                onClick = {},
                border = BorderStroke(width = 1.dp, color = Color.White),
                shape = RoundedCornerShape(5.dp)
            ) {
                Text(
                    text = "Masuk disini",
                    color = Color.White
                )
            }
        }
    }
}