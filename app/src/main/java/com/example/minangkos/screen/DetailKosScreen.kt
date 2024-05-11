package com.example.minangkos.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.minangkos.R
import com.example.minangkos.ui.theme.MinangkosandroidTheme
import com.example.minangkos.ui.theme.Primary

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailKosScreen() {
    Scaffold(
        bottomBar = { BottomBar() }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                painter = painterResource(id = R.drawable.bed1),
                contentDescription = "image kos bedroom",
                contentScale = ContentScale.FillBounds
            )
        }
    }
}

@Composable
fun BottomBar() {
    Column(
        modifier = Modifier.padding(15.dp)
    ) {
        Divider()
        Row(
            modifier = Modifier.padding(vertical = 10.dp)
        ) {
            Text(
                modifier = Modifier.alpha(0.7f),
                text = "Rp1.800.000",
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier.alpha(0.7f),
                text = "/bulan"
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            OutlinedButton(
                modifier = Modifier.weight(1f),
                onClick = {},
                border = BorderStroke(width = 1.dp, color = Primary),
                shape = RoundedCornerShape(5.dp)
            ) {
                Icon(
                    modifier = Modifier.padding(end = 10.dp),
                    imageVector = Icons.Outlined.Email,
                    contentDescription = "Icon Chat",
                    tint = Primary
                )
                Text(
                    text = "Tanya Pemilik",
                    color = Primary
                )
            }

            Spacer(modifier = Modifier.size(15.dp))

            Button(
                modifier = Modifier.weight(1f),
                onClick = {},
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Primary
                )
            ) {
                Text(text = "Ajukan Sewa")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MinangkosandroidTheme {
        DetailKosScreen()
    }
}