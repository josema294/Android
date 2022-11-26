package com.example.calculadoraimcdejose

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {

    //Inicio variables que usaremos en la app

    lateinit var textCM: TextView
    lateinit var textKG: TextView
    lateinit var rbutonF: RadioButton
    lateinit var rbutonM: RadioButton
    lateinit var submit: Button
    lateinit var mostradoIMC: TextView
    lateinit var img :ImageView
    var imc: Double? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Referencio vistas

        textCM = findViewById(R.id.editTextTextAltura)
        textKG = findViewById(R.id.editTextTextPeso)
        rbutonM = findViewById(R.id.radioButtonMale)
        rbutonF = findViewById(R.id.radioButtonFemale)
        submit = findViewById(R.id.btnSubmit)
        mostradoIMC = findViewById(R.id.mostradoIMC)
        img = findViewById(R.id.imgEmoji)


        //logica principal de la aplicacion activada al pulsar el boton submit si allData is True ejecuta calculos imc si False snack

        submit.setOnClickListener {

            if (allData()) {

                principal()
            } else {
                //llamamos a snackbar
                snack()
            }

        }


    }


    /*Creo una funcion a checkear si algun valor se ha dejado en blanco o no
     * si algun valor no es valido, alldata devolvera un false.
     */
    fun allData(): Boolean {

        var isAllData = true

        if (textCM.text.isEmpty()) {
            isAllData = false
        }
        if (textKG.text.isEmpty()) {
            isAllData = false
        }
        if (!rbutonF.isChecked && !rbutonM.isChecked) {
            isAllData = false
        }
        return isAllData
    }

    //Creamos una funcion que mostrara un snackbar con notificacion.
    fun snack() {

        val mySnackbar = Snackbar.make(findViewById(R.id.rootlayout), R.string.snack, 2000)
        mySnackbar.show()

    }

    //funcion calculo del imc devolvera un entero que representa los posibles resultados
    fun imc(): Int {

        val gendermale = rbutonM.isActivated
        val weight: Int = (textKG.text.toString()).toInt()
        val height: Int = (textCM.text.toString()).toInt()


        imc = (weight.toDouble() / height.toDouble() / 10)
        var imcResultado = 0

        if (gendermale) {

            if (imc!! < 18.5) {
                imcResultado = 0
            }
            if (18.5 <= imc!! && imc!! < 24.9) {
                imcResultado = 1
            }
            if (24.9 <= imc!! && imc!! < 30.9) {
                imcResultado = 2
            }
            if (30 <= imc!! && imc!! < 35.9) {
                imcResultado = 3
            }
            if (35 <= imc!! && imc!! < 39.9) {
                imcResultado = 4
            }
            if (imc!! > 39.9) {
                imcResultado = 4
            }
        }

        if (!gendermale) {

            if (imc!! < 16.5) {
                imcResultado = 0
            }
            if (16.5 <= imc!! && imc!! <= 22.9) {
                imcResultado = 1
            }
            if (22.9 < imc!! && imc!! <= 25.9) {
                imcResultado = 2
            }
            if (26 < imc!! && imc!! <= 30.9) {
                imcResultado = 3
            }
            if (31 < imc!! && imc!! <= 33.9) {
                imcResultado = 4
            }
            if (imc!! > 33.9) {
                imcResultado = 4
            }

        }


        return imcResultado


    }


    //Funcion que realiza las acciones principales cuando se tienen todos los datos requeridos


    @SuppressLint("ResourceType")
    fun principal() {

        val resultado = imc()
        /* val animation = findViewById<LottieAnimationView>(R.id.animationAvocado)*/
        val img = findViewById<ImageView>(R.id.imgEmoji)

        img.visibility = View.VISIBLE
        mostradoIMC.text = (getString(R.string.mostrarIMC) + imc)
        mostradoIMC.visibility = View.VISIBLE
        /*animation.isVisible = false*/


        when (resultado) {

            0 -> {img.setImageResource(R.raw.bajo) }
            1 -> {img.setImageResource(R.raw.normal) }
            2 -> {img.setImageResource(R.raw.sobrepeso) }
            3 -> {img.setImageResource(R.raw.obesidad1) }
            4 -> {img.setImageResource(R.raw.obesidad2) }
            5 -> {img.setImageResource(R.raw.obesidad3) }
        }


    }

}

















