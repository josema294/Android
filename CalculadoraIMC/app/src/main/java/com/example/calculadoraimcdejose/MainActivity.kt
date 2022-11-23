package com.example.calculadoraimcdejose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView



class MainActivity : AppCompatActivity() {

    //Inicio variables que usaremos en la app
    var gender: Boolean? = null
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

    }




}






