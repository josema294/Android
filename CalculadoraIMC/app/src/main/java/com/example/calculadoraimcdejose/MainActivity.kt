package com.example.calculadoraimcdejose

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.airbnb.lottie.LottieAnimationView
import com.google.android.material.snackbar.Snackbar
import java.text.DecimalFormat


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

    //funcion calculo del imc y devolvera un entero que representa los posibles rangos del imc
    fun imc(): Int {

        val gendermale = rbutonM.isChecked
        val weight: Double = (textKG.text.toString()).toDouble()
        val height: Double = ((textCM.text.toString()).toDouble())/100

        imc = weight/ Math.pow(height,2.0)
        var imcResultado = 0

        if (gendermale) {

            if (imc!! < 18.5) {
                imcResultado = 0
            }
            if (18.5 <= imc!! && imc!! < 25) {
                imcResultado = 1
            }
            if (25 <= imc!! && imc!! < 30.0) {
                imcResultado = 2
            }
            if (30 <= imc!! && imc!! < 35.0) {
                imcResultado = 3
            }
            if (35 <= imc!! && imc!! < 40) {
                imcResultado = 4
            }
            if (imc!! >= 40) {
                imcResultado = 5
            }

                   }

        if (!gendermale) {

            if (imc!! < 16.5) {
                imcResultado = 0
            }
            if (16.5 <= imc!! && imc!! < 23) {
                imcResultado = 1
            }
            if (23.0 <= imc!! && imc!! < 26.0) {
                imcResultado = 2
            }
            if (26 <= imc!! && imc!! < 31) {
                imcResultado = 3
            }
            if (31 <= imc!! && imc!! < 34) {
                imcResultado = 4
            }
            if ( imc!! >= 34) {
                imcResultado = 5
            }

        }


        return imcResultado


    }


    //Funcion que realiza las acciones principales cuando se tienen todos los datos requeridos


    @SuppressLint("ResourceType")
    fun principal() {

        val resultado =  imc()
        val formateado = DecimalFormat("##.##")
        val imcMostrar = formateado.format(imc)
       // val imcMostrar : String = resultado.toString()
        val animation = findViewById<LottieAnimationView>(R.id.animationAvocado)
        val img = findViewById<ImageView>(R.id.imgEmoji)

        img.visibility = View.VISIBLE
        mostradoIMC.visibility = View.VISIBLE
        animation.isVisible = false


        when (resultado) {

            0 -> {img.setImageResource(R.raw.bajo)
                mostradoIMC.text = (getString(R.string.mostrarIMC) + imcMostrar  + "\n" + getString(R.string.bajo) )}
            1 -> {img.setImageResource(R.raw.normal)
                mostradoIMC.text = (getString(R.string.mostrarIMC) + imcMostrar + "\n" + getString(R.string.normal) )}
            2 -> {img.setImageResource(R.raw.sobrepeso)
                mostradoIMC.text = (getString(R.string.mostrarIMC) + imcMostrar + "\n" + getString(R.string.sobrepeso) )}
            3 -> {img.setImageResource(R.raw.obesidad1)
                mostradoIMC.text = (getString(R.string.mostrarIMC) + imcMostrar + "\n" + getString(R.string.obesidad1) )}
            4 -> {img.setImageResource(R.raw.obesidad2)
                mostradoIMC.text = (getString(R.string.mostrarIMC) + imcMostrar + "\n" + getString(R.string.obesidad2) )}
            5 -> {img.setImageResource(R.raw.obesidad3)
                mostradoIMC.text = (getString(R.string.mostrarIMC) + imcMostrar + "\n" + getString(R.string.obesidad3) )}
        }


    }

}

















