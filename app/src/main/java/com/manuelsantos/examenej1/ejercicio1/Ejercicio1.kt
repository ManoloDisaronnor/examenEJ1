package com.manuelsantos.examenej1.ejercicio1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.manuelsantos.examenej1.modelo.VideoJuego

@Composable
fun Ejercicio1() {
    val listaVideoJuego = listOf(
        VideoJuego("Spider-man", 79.99, "https://loremflickr.com/400/400/seville?lock=1"),
        VideoJuego("Super-man", 89.99, "https://loremflickr.com/400/400/seville?lock=2"),
        VideoJuego("Gta", 59.99, "https://loremflickr.com/400/400/seville?lock=3"),
        VideoJuego("Slender-man", 3.99, "https://loremflickr.com/400/400/seville?lock=4"),
        VideoJuego("Rocket-league", 4.99, "https://loremflickr.com/400/400/seville?lock=5"),
        VideoJuego("Clash Royale", 5.99, "https://loremflickr.com/400/400/seville?lock=6"),
        VideoJuego("Clash of Clans", 9.99, "https://loremflickr.com/400/400/seville?lock=7"),
        VideoJuego("Agar.io", 49.99, "https://loremflickr.com/400/400/seville?lock=8"),
        VideoJuego("Slither.io", 29.99, "https://loremflickr.com/400/400/seville?lock=9")
    )
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Lista de videojuegos", style = MaterialTheme.typography.titleLarge, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.padding(vertical = 8.dp))
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(listaVideoJuego) { videojuego ->
                    CardVideojuego(videojuego)
                }
            }
        }

    }
}

@Composable
fun CardVideojuego(videoJuego: VideoJuego) {
    Card(
        modifier = Modifier.fillMaxWidth()
            .padding(16.dp),
        colors = CardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = Color.Black,
            disabledContainerColor = Color.Gray,
            disabledContentColor = Color.Gray
        )
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = videoJuego.imageUrl,
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.padding(vertical = 8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Nombre del videojuego: ", style = MaterialTheme.typography.titleLarge, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Text(videoJuego.name, style = MaterialTheme.typography.titleLarge, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Precio del videojuego: ", style = MaterialTheme.typography.titleLarge, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Text("${videoJuego.price}€", style = MaterialTheme.typography.titleLarge, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}