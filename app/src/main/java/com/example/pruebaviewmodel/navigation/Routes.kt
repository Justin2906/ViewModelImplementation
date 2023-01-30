package com.example.pruebaviewmodel.navigation

sealed class Routes(val ruta: String) {
    object  SplashScreen: Routes("Splash Screen")
    object Inicio : Routes("Inicio")
    object Add: Routes("Add")
    object Delete: Routes("Delete")
    object Modify: Routes("Modify")

}