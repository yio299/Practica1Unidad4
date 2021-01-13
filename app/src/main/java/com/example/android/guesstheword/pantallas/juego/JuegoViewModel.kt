package com.example.android.guesstheword.pantallas.juego

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class JuegoViewModel : ViewModel() {


    private val _palabra = MutableLiveData<String>()
    val palabra : LiveData<String> get() = _palabra

    private val _puntuacion = MutableLiveData<Int>()
    val puntuacion : LiveData<Int> get() = _puntuacion

    private val _ElEventoTermino = MutableLiveData<Boolean>()
    val ElEventoTermino : LiveData<Boolean> get() = _ElEventoTermino

    private lateinit var listaDePalabras: MutableList<String>


    init {
        Log.i("JuegoViewModel","JuegoVIewModel creado!!")
        _ElEventoTermino.value=false
        reiniciarLista()
        siguientePalabra()

        _puntuacion.value = 0
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("JuegoViewModel","JuegoVIewModel destruido!!")
    }

    private fun reiniciarLista() {
        listaDePalabras = mutableListOf(
                "princesa",
                "hospital",
                "baloncesto",
                "gato",
                "monedas",
                "perro",
                "sopa",
                "calendario",
                "triste",
                "escritorio",
                "guitarra",
                "casa",
                "carretera",
                "elefante",
                "llanta",
                "carro",
                "silla",
                "teléfono",
                "bolsa",
                "botella",
                "arma"
        )
        listaDePalabras.shuffle()
    }

    private fun siguientePalabra() {
        //Select and remove a word from the list
        if (listaDePalabras.isEmpty()) {
            _ElEventoTermino.value=true
        } else {
            _palabra.value = listaDePalabras.removeAt(0)
        }

    }

    fun clickOmitir() {
        _puntuacion.value = (puntuacion.value)?.minus(1)
        siguientePalabra()
    }

    fun clickLoConseguiste() {
        _puntuacion.value = (puntuacion.value)?.plus(1)
        siguientePalabra()
    }

    fun terminarJuego(){

        _ElEventoTermino.value=false
    }


}