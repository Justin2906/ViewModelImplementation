package com.example.pruebaviewmodel.views

import android.util.Log
import android.view.View
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pruebaviewmodel.viewmodels.ViewModelQuery
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun VistaConsultar(ViewModel: ViewModelQuery){
    var nombre_coleccion = "jugadores"
    val db = FirebaseFirestore.getInstance()

    //imagenes usadas
    val back = painterResource(id = com.example.pruebaviewmodel.R.drawable.fondo4)
    val logo = painterResource(id = com.example.pruebaviewmodel.R.drawable.logo)

    val dorsal:String by ViewModel.dorsal.observeAsState("")
    val nombre:String by ViewModel.nombre.observeAsState("")
    val division:String by ViewModel.division.observeAsState("")
    val posicion:String by ViewModel.posicion.observeAsState("")
    val isButtonEnable:Boolean by ViewModel.isButtonEnable.observeAsState (false)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(painter = back, contentScale = ContentScale.FillBounds)
    )
    {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(state = rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            Image(
                painter = logo,
                contentDescription = null
            )

            Text(
                text = "Consultar jugador",
                color = Color.White,
                fontSize = 35.sp
            )

            OutlinedTextField(
                value = dorsal,
                onValueChange = { ViewModel.onCompletedFields(dorsal= it)},
                label = { Text("Introduce el dorsal del jugador") },
                modifier = Modifier.background(Color.White, shape = CutCornerShape(12.dp)),
                singleLine = true,
            )

            Spacer(modifier = Modifier.size(5.dp))

            Button(
                onClick = {
                    ViewModel.buscarDatosJugador(db, nombre_coleccion, dorsal)
                },
                enabled= isButtonEnable,
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                shape = CutCornerShape(12.dp),
                modifier = Modifier
                    .width(250.dp)
                    .height(50.dp)
            )

            {
                Text(text = "Cargar Datos")
            }

            Spacer(modifier = Modifier.size(10.dp))

            // PINTAMOS EL RESULTADO DE LA CONSULTA A LA BASE DE DATOS
            //Text (text = datos)
            Text(text = "Nombre: " + nombre, color = Color.White,fontWeight = FontWeight.Bold, fontSize = 30.sp)
            Text(text = "Dorsal: " + dorsal, color = Color.White,fontWeight = FontWeight.Bold, fontSize = 30.sp)
            Text(text = "Division: " + division, color = Color.White,fontWeight = FontWeight.Bold, fontSize = 30.sp)
            Text(text = "Posicion: " + posicion, color = Color.White,fontWeight = FontWeight.Bold, fontSize = 30.sp)
        }
    }
}