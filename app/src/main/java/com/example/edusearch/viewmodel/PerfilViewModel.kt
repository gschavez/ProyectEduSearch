package com.example.edusearch.viewmodel

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.edusearch.model.PerfilData

class PerfilViewModel : ViewModel() {//viewmodel encargado de gestionar los datos de perfil

    val perfil = PerfilData.perfil//obtiene los datos

    var mostrarInfoAdicional by mutableStateOf(false)//el "mutableStateOf" permite que compose reaccione a cambios
        private set

    fun toggleInfoAdicional() {
        mostrarInfoAdicional = !mostrarInfoAdicional//funcion del estato de la informacino (true/false)
    }
}