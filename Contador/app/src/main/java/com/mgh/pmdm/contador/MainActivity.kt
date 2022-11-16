package com.mgh.pmdm.contador

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var contador = 0
    var playorpause = true

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencia al TextView
        val textViewContador = findViewById<TextView>(R.id.textViewContador)

        // Inicializamos el TextView con el contador a 0
        textViewContador.text = contador.toString()

        // Referencia al botón
        val btAdd = findViewById<Button>(R.id.btAdd)

        // Referencia a el boton de apagar o encender la musica

        val btnplayorpause = findViewById<Switch>(R.id.switch1)


        //Referencia al boton de reseteo

        val reset = findViewById<ImageButton>(R.id.btnreset)

        //Referencia al boton de restar

        val substrac = findViewById<Button>(R.id.btsubtrac)

        //Preparamos el reproductor de audio para cuando se acrtive o desactive

        var mediaPlayer: MediaPlayer? = MediaPlayer.create(this, R.raw.musica)

        //asociamos eventoclick a reset para que reinicie contador y fije valor
        reset.setOnClickListener {
            contador = 0
            textViewContador.text = getString(R.string.z)
        }

        //asociamos eventoclick a btadd para que ++ a contador y fije valor
        btAdd.setOnClickListener {
            contador++

            textViewContador.setText(randomizerplus() + contador.toString())
        }

        //asociamos evento a substrac para que contador --

        substrac.setOnClickListener{

            contador --
            textViewContador.setText(randomizerless() + contador.toString())
        }
        //comprobamos con un condicional el estado del switch para hacer sonar o no la musica
        btnplayorpause.setOnClickListener {

        if (btnplayorpause.isChecked) {
            mediaPlayer?.start()

        }

        else {
            mediaPlayer?.stop()

        }

        }


    }

    // Creamos funciona que arroja de forma aleatoria strings de nuestros recursos
    fun randomizerplus (): String {

        when (Random.nextInt(1, 6)) {


            1 -> return getString(R.string.a)
            2 -> return getString(R.string.b)
            3 -> return getString(R.string.c)
            4 -> return getString(R.string.d)
            5 -> return getString(R.string.e)
        }

        return ""
    }

    fun randomizerless (): String {

        when (Random.nextInt(1, 6)) {


            1 -> return getString(R.string.f)
            2 -> return getString(R.string.g)
            3 -> return getString(R.string.h)
            4 -> return getString(R.string.i)
            5 -> return getString(R.string.j)
        }

        return ""
    }
}






