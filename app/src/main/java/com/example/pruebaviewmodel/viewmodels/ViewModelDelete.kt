package com.example.pruebaviewmodel.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore

class ViewModelDelete {
    private val _dorsal = MutableLiveData<String>()
    val dorsal : LiveData<String> = _dorsal

    private val _mensajeConfirmacion = MutableLiveData<String>()
    val mensajeConfirmacion: LiveData<String> = _mensajeConfirmacion

    private val _isButtonEnable = MutableLiveData<Boolean>()
    var isButtonEnable: LiveData<Boolean> = _isButtonEnable

    fun peticionEliminarDatos(db: FirebaseFirestore, nombre_coleccion:String, id: String){
        db.collection(nombre_coleccion)
            .document(id)
            .delete()
            .addOnSuccessListener {
                _mensajeConfirmacion.value = "jugador borrado correctamente"
            }
            .addOnFailureListener {
                _mensajeConfirmacion.value = "No se ha podido borrar el jugador"
            }
    }

    fun onCompletedFieldsDelete(dorsal:String) {
        _dorsal.value = dorsal
        _isButtonEnable.value = enableButtonDelete(dorsal)
    }

    fun enableButtonDelete(dorsal:String) =
        //Patterns.EMAIL_ADDRESS.matcher(mail).matches()
        dorsal.length >0
}