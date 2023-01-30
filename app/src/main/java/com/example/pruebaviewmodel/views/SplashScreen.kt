package com.example.pruebaviewmodel.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pruebaviewmodel.R
import com.example.pruebaviewmodel.navigation.Routes
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController){
    LaunchedEffect(key1 = true){
        delay(4000)
        navController.popBackStack()
        navController.navigate(Routes.Inicio.ruta)
    }

    Splash()
}

@Composable
fun Splash(){
    val back = painterResource(id = R.drawable.fondo4)
    val logo = painterResource(id = R.drawable.logo)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(painter = back, contentScale = ContentScale.FillBounds),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = logo,
            contentDescription = "Logo Peticiones",
            modifier = Modifier.size(150.dp, 150.dp)
        )
        Text(
            text = "Bienvenidos",
            color = Color.White,
            fontSize = 36.sp
        )
    }
}