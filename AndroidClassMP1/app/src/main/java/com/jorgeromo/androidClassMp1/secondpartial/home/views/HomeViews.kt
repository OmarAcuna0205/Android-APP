// com/jorgromo/androidClassMp1/secondpartial/home/views/HomeViews.kt

package com.jorgeromo.androidClassMp1.secondpartial.home.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.jorgeromo.androidClassMp1.secondpartial.home.model.HomeSection
import com.jorgeromo.androidClassMp1.secondpartial.home.model.Listing
import com.jorgeromo.androidClassMp1.secondpartial.home.viewmodel.HomeViewModel

@Composable
fun HomeScreen(homeViewModel: HomeViewModel = viewModel()) {
    val sections by homeViewModel.homeSections.collectAsState()
    val errorMessage by homeViewModel.errorMessage.collectAsState()

    if (errorMessage != null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = errorMessage ?: "Error desconocido")
        }
    } else if (sections.isEmpty()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    } else {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(sections) { section ->
                HomeSectionView(section = section)
            }
        }
    }
}

@Composable
fun HomeSectionView(section: HomeSection) {
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Text(
            text = section.sectionTitle,
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(section.listings) { listing ->
                ListingItem(listing = listing)
            }
        }
    }
}

/**
 * ✨ VERSIÓN COMPACTA ✨
 * Con título en una sola línea y tarjetas más pequeñas.
 */
@Composable
fun ListingItem(listing: Listing) {
    Card(
        modifier = Modifier.width(220.dp), // Ancho de la tarjeta
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column {
            // Imagen principal de la publicación
            AsyncImage(
                model = listing.imageUrl,
                contentDescription = listing.title,
                modifier = Modifier
                    .height(120.dp) // Altura de la imagen reducida
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )

            // Contenedor para el texto con padding y altura ajustada
            Column(
                modifier = Modifier
                    .padding(horizontal = 12.dp, vertical = 8.dp) // Padding ajustado
                    .height(100.dp) // Altura fija para el contenido de texto
            ) {
                // Título - ahora en una sola línea
                Text(
                    text = listing.title,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1, // Una sola línea
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.titleMedium.copy(fontSize = 17.sp) // Un poco más pequeño para ajustarse
                )

                Spacer(modifier = Modifier.height(6.dp)) // Espacio reducido

                // Fila para la información del usuario (Avatar + Nombre)
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AsyncImage(
                        model = listing.user.avatarUrl,
                        contentDescription = "Avatar de ${listing.user.name}",
                        modifier = Modifier
                            .size(20.dp) // Avatar más pequeño
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.width(6.dp)) // Espacio reducido
                    Text(
                        text = listing.user.name,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                // Spacer ocupa el espacio disponible para empujar el precio hacia abajo
                Spacer(modifier = Modifier.weight(1f))

                // Precio - alineado a la izquierda por defecto
                listing.price?.let {
                    Text(
                        text = "$${it} ${listing.currency}",
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}