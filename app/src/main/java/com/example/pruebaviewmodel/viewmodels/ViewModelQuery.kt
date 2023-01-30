package com.example.pruebaviewmodel.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ViewModelQuery {
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

    fun onCompletedFields(dorsal:String) {
        _dorsal.value = dorsal
        _isButtonEnable.value = enableButton(dorsal)
    }

    fun enableButton(dorsal:String) =
        //Patterns.EMAIL_ADDRESS.matcher(mail).matches()
        dorsal.length >0
}