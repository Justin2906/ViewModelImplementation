package com.example.pruebaviewmodel.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ViewModelDelete {
    private val _dorsal = MutableLiveData<String>()
    val dorsal : LiveData<String> = _dorsal

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