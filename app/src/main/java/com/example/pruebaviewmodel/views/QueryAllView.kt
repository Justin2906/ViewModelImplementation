package com.example.pruebaviewmodel.views

import android.content.ContentValues
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pruebaviewmodel.model.Jugadores
import com.example.pruebaviewmodel.viewmodels.ViewModelQueryAll
import com.google.firebase.firestore.FirebaseFirestore


/*@Composable
fun PlayerCard(jugadores: Jugadores,) {
    Surface(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = 8.dp,
        color = Color(0xFF11273F),
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFF647E9C),
                            Color(0xFF081424)
                        )
                    ),
                    shape = CutCornerShape(5.dp)
                )
        ) {

            Text(
                text = "Nombre: " +  jugadores.Nombre,
                style = MaterialTheme.typography.h5,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                color = Color.White
            )
            Text(
                text = "Dorsal: " + jugadores.Dorsal,
                style = MaterialTheme.typography.h5,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                color = Color.White
            )
            Text(
                text = "Division: " + jugadores.Division,
                style = MaterialTheme.typography.h5,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                color = Color.White
            )
            Text(
                text = "Posicion: " + jugadores.Posicion,
                style = MaterialTheme.typography.h5,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                color = Color.White
            )
        }
    }
}

@Composable
fun ConsultarTodo(ViewModel: ViewModelQueryAll){
    val db = FirebaseFirestore.getInstance()
    var nombre_coleccion = "jugadores"

    val back = painterResource(id = com.example.pruebaviewmodel.R.drawable.fondo4)
    val logo = painterResource(id = com.example.pruebaviewmodel.R.drawable.logo)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(painter = back, contentScale = ContentScale.FillBounds)
    )
    {


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

            Text(
                text = "Consultar jugadores",
                color = Color.White,
                fontSize = 35.sp
            )

            var listaPlayers by remember { mutableStateOf(listOf<Jugadores>()) }
            var datosJugadores by remember { mutableStateOf("") }

            Button(
                onClick = {
                    db.collection(nombre_coleccion)
                        .get()
                        .addOnSuccessListener { search ->
                            for (encontrado in search) {
                                //datosJugadores += "${document.id}: ${document.data}\n\n"
                                listaPlayers += Jugadores(
                                    encontrado["nombre"].toString(),
                                    encontrado["dorsal"].toString(),
                                    encontrado["division"].toString(),
                                    encontrado["posicion"].toString()
                                )
                                //Log.d("Datos", lista.listaJugadores.toString())
                            }
                            datosJugadores += listaPlayers.toString()
                            if (datosJugadores.isEmpty()){
                                datosJugadores = "No existen registros"
                            }
                        }
                        .addOnFailureListener { exception ->
                            datosJugadores = "No se a podido recoger los datos"
                            Log.w(ContentValues.TAG, "Error getting documents: ", exception)
                        }


                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                shape = CutCornerShape(12.dp),
                modifier = Modifier
                    .width(250.dp)
                    .height(50.dp)
            ) {
                Text(
                    text = "Cargar Jugadores",
                    color = Color.Black,
                    fontSize = 16.sp
                )
            }
            Player(listaPlayers)
        }
    }
}

@Composable
fun PlayerList(lista: List<Jugadores>){
    LazyColumn(
    ){
        items(lista){jugador ->
            PlayerCard(jugador)
        }
    }
}

@Composable
fun Player(lista: List<Jugadores>){
    Column(
    ) {
        PlayerList(lista =lista)
        Log.d("Datos", lista.toString())
    }
}*/