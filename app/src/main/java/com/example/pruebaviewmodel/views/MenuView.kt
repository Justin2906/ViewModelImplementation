package com.example.pruebaviewmodel.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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


@Composable
fun Options(navController: NavHostController){
    val back = painterResource(id = R.drawable.fondo4)
    val logo = painterResource(id = R.drawable.logo)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(painter = back, contentScale = ContentScale.FillBounds)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                painter = logo,
                contentDescription = null
            )
            Button(
                onClick = { navController.navigate("Add") },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                shape = CutCornerShape(12.dp),
                modifier = Modifier
                    .width(250.dp)
                    .height(50.dp)
            ) {
                Text(
                    text = "Alta",
                    color = Color.Black,
                    fontSize = 16.sp
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            Button(
                onClick = { navController.navigate("Modify")  },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                shape = CutCornerShape(12.dp),
                modifier = Modifier
                    .width(250.dp)
                    .height(50.dp)
            ) {
                Text(
                    text = "Modificar",
                    color = Color.Black,
                    fontSize = 16.sp
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            Button(
                onClick = { navController.navigate("Delete")},
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                shape = CutCornerShape(12.dp),
                modifier = Modifier
                    .width(250.dp)
                    .height(50.dp)
            ) {
                Text(
                    text = "Borrar",
                    color = Color.Black,
                    fontSize = 16.sp
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            Button(
                onClick = { navController.navigate("Search") },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                shape = CutCornerShape(12.dp),
                modifier = Modifier
                    .width(250.dp)
                    .height(50.dp)
            ) {
                Text(
                    text = "Buscar",
                    color = Color.Black,
                    fontSize = 16.sp
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            Button(
                onClick = { navController.navigate("Search All") },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White), shape = CutCornerShape(12.dp),
                modifier = Modifier
                    .width(250.dp)
                    .height(50.dp)
            ) {
                Text(
                    text = "Información General",
                    color = Color.Black,
                    fontSize = 16.sp
                )
            }
        }
    }
}