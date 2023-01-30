package com.example.pruebaviewmodel.views

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pruebaviewmodel.R
import com.example.pruebaviewmodel.viewmodels.ViewModelGeneral
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun ModificarDatos(ViewModel: ViewModelGeneral) {

    val back = painterResource(id = R.drawable.fondo4)
    val logo = painterResource(id = R.drawable.logo)

    val db = FirebaseFirestore.getInstance()
    var nombre_coleccion = "jugadores"

    val dorsal:String by ViewModel.dorsal.observeAsState(initial = "")
    val nombre:String by ViewModel.nombre.observeAsState (initial = "")
    val division:String by ViewModel.division.observeAsState(initial = "")
    val posicion:String by ViewModel.posicion.observeAsState (initial = "")
    val isButtonEnable:Boolean by ViewModel.isButtonEnable.observeAsState (initial = false)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(painter = back, contentScale = ContentScale.FillBounds)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(state = rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            Image(painter = logo, contentDescription = null)

            Text(text = "Guardar nuevo jugador",
                color = Color.White,
                fontSize = 35.sp)

            Spacer(modifier = Modifier.size(20.dp))

            OutlinedTextField(
                value = dorsal,
                onValueChange = { ViewModel.onCompletedFields(dorsal = it, nombre = nombre, division = division, posicion = posicion) },
                label = { Text("Dorsal del jugador a modificar") },
                modifier = Modifier.background(Color.White, shape = CutCornerShape(12.dp)),
                singleLine = true,
            )

            Spacer(modifier = Modifier.size(5.dp))

            OutlinedTextField(
                value = nombre,
                onValueChange = { ViewModel.onCompletedFields(dorsal = dorsal, nombre = it, division = division, posicion = posicion) },
                label = { Text("Nombre del jugador a modificar") },
                modifier = Modifier.background(Color.White, shape = CutCornerShape(12.dp)),
                singleLine = true,
            )

            Spacer(modifier = Modifier.size(5.dp))

            OutlinedTextField(
                value = division,
                onValueChange = { ViewModel.onCompletedFields(dorsal = dorsal, nombre = nombre, division = it, posicion = posicion) },
                label = { Text("Division del jugador a modificar") },
                modifier = Modifier.background(Color.White, shape = CutCornerShape(12.dp)),
                singleLine = true,
            )

            Spacer(modifier = Modifier.size(5.dp))

            OutlinedTextField(
                value = posicion,
                onValueChange = { ViewModel.onCompletedFields(dorsal = dorsal, nombre = nombre, division = division, posicion = it) },
                label = { Text("Posicion del jugador a modificar") },
                modifier = Modifier.background(Color.White, shape = CutCornerShape(12.dp)),
                singleLine = true,
            )

            Spacer(modifier = Modifier.size(5.dp))

            val dato = hashMapOf(
                "dorsal" to dorsal.toString(),
                "nombre" to nombre.toString(),
                "division" to division.toString(),
                "posicion" to posicion.toString()
            )

            var mensaje_confirmacion by remember { mutableStateOf("") }

            Button(
                onClick = {
                    db.collection(nombre_coleccion)
                        .document(dorsal)
                        .set(dato)
                        .addOnSuccessListener {
                            mensaje_confirmacion ="Datos modificados correctamente"
                        }
                        .addOnFailureListener {
                            mensaje_confirmacion ="No se ha podido modificar los datos del jugador"
                        }
                },

                enabled= isButtonEnable,

                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Blue,
                    contentColor = Color.White,
                    disabledBackgroundColor = Color(0xFF78C8F9),
                    disabledContentColor = Color.White
                ),
                border = BorderStroke(1.dp, Color.Black)
            ){
                Text(
                    text = "Modificar"
                )

            }
            Spacer(modifier = Modifier.size(5.dp))
            Text(
                text = mensaje_confirmacion,
                color = Color.White
            )
        }
    }
}