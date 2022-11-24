package com.example.calculadoraimcdejose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.OnClickAction
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {

    //Inicio variables que usaremos en la app
    var gendermale: Boolean? = null
    var weight: Int? = null
    var height: Int? = null
    lateinit var textCM :TextView
    lateinit var textKG :TextView
    lateinit var rbutonF :RadioButton
    lateinit var rbutonM :RadioButton
    lateinit var submit :Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Referencio vistas de layout

        //val textCM = findViewById<TextView>(R.id.editTextTextAltura)
        textCM = findViewById(R.id.editTextTextAltura)
        textKG  = findViewById(R.id.editTextTextPeso)
        rbutonM = findViewById(R.id.radioButtonMale)
        rbutonF  = findViewById(R.id.radioButtonFemale)
        submit = findViewById(R.id.btnSubmit)

        submit.setOnClickListener {

            if (!allData()) {

                //llamamos a calculo imc
                imc()
            }

            else {
                //llamamos a snackbar
                snack()
            }

        }


    }




    /*Creo una funcion a checkear si algun valor se ha dejado en blanco o no
     * si algun valor no es valido, alldata devolvera un false.
     */
    fun allData(): Boolean {

        var isAllData: Boolean = true

        if (textCM.text == null) { isAllData = false}
        if (textKG.text == null) { isAllData = false}
        if (rbutonF.text == null && rbutonM.text == null) { isAllData = false}
        return isAllData
    }
    //Creamos una funcion que mostrara un snackbar con notificacion.
    fun snack() {

        val mySnackbar = Snackbar.make(findViewById(R.id.rootlayout), R.string.snack,1000 )
        mySnackbar.show()

    }

    //funcion calculo del imc devolvera un entero que representa los posibles resultados
    fun imc(): Int {

        var imc: Double = (weight!!/ height!!).toDouble()
        var imcResultado = null

        if (gendermale!!) {

            if (imc< 18.5) {imcResultado=0}
            if (18.5<=imc && imc <24.9 ) {imcResultado=1}
            if (24.9<=imc && imc <30.9) {imcResultado=2}
            if (30<=imc && imc <35.9) {imcResultado=3}
            if (35<=imc && imc <39.9 ) {imcResultado=4}
            if (imc > 39.9 ) {imcResultado=4}
        }

        if (!gendermale!!) {

            if (imc< 16.5) {imcResultado=0}
            if (16.5<=imc && imc <22.9 ) {imcResultado=1}
            if (23.9<=imc && imc <25.9) {imcResultado=2}
            if (30<=imc && imc <30.9) {imcResultado=3}
            if (35<=imc && imc <33.9 ) {imcResultado=4}
            if (imc > 39.9 ) {imcResultado=4}

        }

        return imcResultado!!


    }




}






