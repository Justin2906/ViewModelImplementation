package com.example.pruebaviewmodel.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore

class ViewModelGeneral {
    private val _dorsal = MutableLiveData<String>()
    val dorsal : LiveData<String> = _dorsal

    private val _nombre = MutableLiveData<String>()
    val nombre : LiveData<String> = _nombre

    private val _division = MutableLiveData<String>()
    val division : LiveData<String> = _division

    private val _posicion= MutableLiveData<String>()
    val posicion : LiveData<String> = _posicion

    private val _mensajeConfirmacion = MutableLiveData<String>()
    val mensajeConfirmacion: LiveData<String> = _mensajeConfirmacion

    private val _isButtonEnable = MutableLiveData<Boolean>()
    var isButtonEnable: LiveData<Boolean> = _isButtonEnable

    fun peticionGuardarDatos(db: FirebaseFirestore, nombre_coleccion:String, id: String, datos: HashMap<String, String>){
        db.collection(nombre_coleccion)
            .document(id)
            .set(datos)
            .addOnSuccessListener {
                _mensajeConfirmacion.value = "Guardado correctamente"
            }
            .addOnFailureListener {
                _mensajeConfirmacion.value = "No se ha podido guardado"
            }
    }

    fun onCompletedFields(dorsal:String, nombre:String, division:String, posicion:String) {
        _dorsal.value = dorsal
        _nombre.value = nombre
        _division.value = division
        _posicion.value = posicion
        _isButtonEnable.value = enableButton(dorsal, nombre,division,posicion)
    }

    fun enableButton(dorsal:String, nombre:String, division:String, posicion:String) =
        //Patterns.EMAIL_ADDRESS.matcher(mail).matches()
        dorsal.length >0 && nombre.length >0 && division.length>0 && posicion.length>0


}