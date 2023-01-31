package com.example.pruebaviewmodel.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pruebaviewmodel.viewmodels.ViewModelDelete
import com.example.pruebaviewmodel.viewmodels.ViewModelGeneral
import com.example.pruebaviewmodel.viewmodels.ViewModelQuery
import com.example.pruebaviewmodel.views.*

@Composable
fun NavigationHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.SplashScreen.ruta)
    {

        composable(Routes.SplashScreen.ruta) { SplashScreen(navController)}
        composable(Routes.Inicio.ruta){ Options(navController) }
        composable(Routes.Add.ruta){ GuardarDatos(ViewModelGeneral()) }
        composable(Routes.Delete.ruta){ EliminarDatos(ViewModelDelete())}
        composable(Routes.Modify.ruta){ ModificarDatos(ViewModelGeneral())}
        composable(Routes.Search.ruta){ VistaConsultar(ViewModelQuery())}
        composable(Routes.SearchAll.ruta){ ConsultarTodo()}
    }
}