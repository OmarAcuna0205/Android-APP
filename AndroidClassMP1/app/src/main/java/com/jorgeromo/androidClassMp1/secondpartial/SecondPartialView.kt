package com.jorgeromo.androidClassMp1.secondpartial // Asegúrate que el package sea el correcto

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.jorgeromo.androidClassMp1.navigation.ScreenNavigation

@Composable
fun SecondPartialView(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Segundo Parcial Moviles I",
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp)) // Espacio después del título

        // 1. Botón de Lector QR (ahora va primero)
        Button(
            onClick = {
                navController.navigate(ScreenNavigation.QrCode.route)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Ir a Lector QR")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 2. Botón de Home Screen (ahora va segundo)
        Button(
            onClick = {
                navController.navigate(ScreenNavigation.Home.route)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Ir a la Home Screen (JSON)")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                navController.navigate(ScreenNavigation.LocationCoordinate.route)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Location Coordinate")
        }
    }
}