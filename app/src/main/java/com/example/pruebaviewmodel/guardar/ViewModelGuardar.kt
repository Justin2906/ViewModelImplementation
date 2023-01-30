package com.example.pruebaviewmodel.guardar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ViewModelGuardar {
    private val _dorsal = MutableLiveData<String>()
    val dorsal : LiveData<String> = _dorsal

    private val _nombre = MutableLiveData<String>()
    val nombre : LiveData<String> = _nombre

    private val _division = MutableLiveData<String>()
    val division : LiveData<String> = _division

    private val _posicion= MutableLiveData<String>()
    val posicion : LiveData<String> = _posicion

    private val _isButtonEnable = MutableLiveData<Boolean>()
    val isButtonEnable: LiveData<Boolean> = _isButtonEnable

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