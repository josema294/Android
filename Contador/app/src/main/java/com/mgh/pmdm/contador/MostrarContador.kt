package com.mgh.pmdm.contador

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MostrarContador : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_contador)

        //Recuperamos el valor de contador y lo introducimos en el textview
        val contador: Int? = intent.getIntExtra("contador",0)
        val contadortexview = findViewById<TextView>(R.id.textView2)
        contadortexview.setText(contador.toString())

        //Intent boton de vuelta

        val vuelve  = findViewById<Button>(R.id.btnback)
        vuelve.setOnClickListener { finish() }

        //Imagenfuego
        val flame = findViewById<ImageView>(R.id.imgflame)

        //Generamos animacion en texvie e imagen
        val anim: Animation = AlphaAnimation(0.0f, 1.0f)
        anim.duration = 25
        anim.startOffset = 50
        anim.repeatMode = Animation.REVERSE
        anim.repeatCount = Animation.INFINITE
        contadortexview.startAnimation(anim)
        flame.startAnimation(anim)

    }
}