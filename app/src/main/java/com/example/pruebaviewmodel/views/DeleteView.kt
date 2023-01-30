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
import com.example.pruebaviewmodel.viewmodels.ViewModelDelete
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun EliminarDatos(ViewModel: ViewModelDelete) {

    val back = painterResource(id = R.drawable.fondo4)
    val logo = painterResource(id = R.drawable.logo)

    val db = FirebaseFirestore.getInstance()
    var nombre_coleccion = "jugadores"

    val dorsal:String by ViewModel.dorsal.observeAsState(initial = "")
    val isButtonEnable:Boolean by ViewModel.isButtonEnable.observeAsState(initial = false)

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
                onValueChange = { ViewModel.onCompletedFields(dorsal = it) },
                label = { Text("Introduce el dorsal del jugador") },
                modifier = Modifier.background(Color.White, shape = CutCornerShape(12.dp)),
                singleLine = true,
            )

            Spacer(modifier = Modifier.size(5.dp))

            val dato = hashMapOf(
                "dorsal" to dorsal.toString()
            )

            var mensaje_confirmacion by remember { mutableStateOf("") }

            Button(
                onClick = {
                    db.collection(nombre_coleccion)
                        .document(dorsal)
                        .delete()
                        .addOnSuccessListener {
                            mensaje_confirmacion ="jugador borrado correctamente"
                        }
                        .addOnFailureListener {
                            mensaje_confirmacion ="No se ha podido borrar el jugador"
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
                    text = "Eliminar"
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