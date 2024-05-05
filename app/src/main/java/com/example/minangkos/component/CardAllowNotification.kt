package com.example.minangkos.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.minangkos.R
import com.example.minangkos.ui.theme.Primary

@Composable
fun CardAllowNotification() {
    Card(
        modifier = Modifier.padding(horizontal = 15.dp),
        elevation = CardDefaults.cardElevation(5.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(5.dp)
    ) {
        Row(
            modifier = Modifier.padding(10.dp)
        ) {
            Icon(
                modifier = Modifier
                    .size(35.dp)
                    .padding(end = 10.dp),
                imageVector = Icons.Filled.Notifications,
                contentDescription = "",
                tint = Primary,
            )
            Column {
                Text(
                    text = stringResource(id = R.string.allow_notification),
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
                Text(
                    modifier = Modifier.padding(top = 10.dp, bottom = 20.dp),
                    text = stringResource(id = R.string.allow_notification_body),
                    fontSize = 14.sp
                )
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Primary
                    ),
                    shape = RoundedCornerShape(5.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.allow_notification_btn),
                        color = Color.White,
                        fontSize = 14.sp,
                    )
                }
            }
        }
    }
}