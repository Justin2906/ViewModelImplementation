package com.example.pruebaviewmodel.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore

class ViewModelQuery {
    private val _dorsal = MutableLiveData<String>()
    val dorsal : LiveData<String> = _dorsal

    private val _nombre = MutableLiveData<String>()
    val nombre : LiveData<String> = _nombre

    private val _division = MutableLiveData<String>()
    val division : LiveData<String> = _division

    private val _posicion= MutableLiveData<String>()
    val posicion : LiveData<String> = _posicion

    private val _datos = MutableLiveData<String>()

    private val _isButtonEnable = MutableLiveData<Boolean>()
    val isButtonEnable: LiveData<Boolean> = _isButtonEnable

    //funcion BuscarDatos
    fun buscarDatosJugador(db: FirebaseFirestore, nombre_coleccion:String, id:String){
        // HACEMOS LA CONSULTA A LA COLECCION CON GET
        db.collection(nombre_coleccion)
            .document(id)
            .get()

            //SI SE CONECTA CORRECTAMENTE
            // RECORRO TODOS LOS DATOS ENCONTRADOS EN LA COLECCIÓN Y LOS ALMACENO EN DATOS
            .addOnSuccessListener { encontrado ->

                //Para crear un HashMap con todos los datos
                _datos.value += " ${encontrado.data}\n"

                //Para crear un HashMap con todos los datos
                _nombre.value += encontrado["nombre"].toString()
                _dorsal.value += encontrado["dorsal"].toString()
                _division.value += encontrado["division"].toString()
               _posicion.value += encontrado["posicion"].toString()
                Log.i("DATOS:", _datos.value.toString())


                if (_datos.toString().isEmpty()) {
                    _datos.value = "No existen datos"
                }
            }
            //SI NO CONECTA CORRECTAMENTE
            .addOnFailureListener { resultado ->
                _datos.value = "La conexión a FireStore no se ha podido completar"
            }

        // VACIAMOS VARIABLE AL DAR AL BOTON
        _datos.value = ""
        _dorsal.value = ""
    }

    fun onCompletedFields(dorsal:String) {
        _dorsal.value = dorsal
        _isButtonEnable.value = enableButton(dorsal)
    }

    fun enableButton(dorsal:String) =
        //Patterns.EMAIL_ADDRESS.matcher(mail).matches()
        dorsal.length >0
}