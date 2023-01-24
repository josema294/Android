package com.example.updowngame

import android.app.Application
import android.content.Context
import android.content.Intent
import android.graphics.drawable.AdaptiveIconDrawable
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.collection.arrayMapOf
import androidx.core.graphics.drawable.toDrawable
import com.example.updowngame.databinding.ActivityGameBinding
import com.google.android.material.snackbar.Snackbar
import kotlin.random.Random

class GameActivity : AppCompatActivity() {

    
    private lateinit var binding: ActivityGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        binding= ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nombre = intent.getStringExtra("nombre")
        Snackbar.make(binding.root,"Bienvenido $nombre",Snackbar.LENGTH_INDEFINITE).setAction("Empezar")
        {


            gameLogic()




        }.show()


    }

    //Logica principal del juego
    fun gameLogic () {


        var valorCartaActual = 0
        var valorNuevaCarta = 0
        var score = 0

        randomCard(binding.imageFondo)

            binding.imageButtonUp.setOnClickListener() {

                valorCartaActual = valorCarta(binding.imageFondo)

                randomCard(binding.imageFondo)

                valorNuevaCarta = valorCarta(binding.imageFondo)

                if (valorNuevaCarta>valorCartaActual) {

                    score ++
                    binding.textScore.text = "Score: ${score.toString()}"
                    //Toast.makeText(this,"Has acertado, sumas 1 punto", Toast.LENGTH_SHORT).show()

                }

                else {

                    Toast.makeText(this,"Has fallado se acaba tu juego alcanzaste $score puntos", Toast.LENGTH_LONG).show()

                    startActivity(Intent(this, MainActivity::class.java))

                }



            }

        binding.imageButtonDown.setOnClickListener() {

            valorCartaActual = valorCarta(binding.imageFondo)

            randomCard(binding.imageFondo)

            valorNuevaCarta = valorCarta(binding.imageFondo)

            if (valorNuevaCarta<valorCartaActual) {

                score ++
                binding.textScore.text = "Score: ${score.toString()}"
                //Toast.makeText(this,"Has acertado, sumas 1 punto", Toast.LENGTH_SHORT).show()

            }

            else {

                Toast.makeText(this,"Has fallado se acaba tu juego alcanzaste $score puntos", Toast.LENGTH_LONG).show()

                startActivity(Intent(this, MainActivity::class.java))

            }

        }
    }
    
    //Funcion para elegir carta aleatoriamente
        fun randomCard (imageView: ImageView) {

        var cartas = arrayOf( R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5,R.drawable.c6,
            R.drawable.c7,R.drawable.c8,R.drawable.c9,R.drawable.c10,R.drawable.c11,R.drawable.c12,R.drawable.c13)

        imageView.setImageResource(cartas.random())

        }

    //Funcion para determinar el valor en int de cada carta

        fun valorCarta (imageView: ImageView?) : Int {


            when (imageView?.drawable?.constantState) {




                resources.getDrawable(R.drawable.c1,null).constantState-> { return 1}
                resources.getDrawable(R.drawable.c2,null).constantState-> { return 2}
                resources.getDrawable(R.drawable.c3,null).constantState-> { return 3}
                resources.getDrawable(R.drawable.c4,null).constantState-> { return 4}
                resources.getDrawable(R.drawable.c5,null).constantState-> { return 5}
                resources.getDrawable(R.drawable.c6,null).constantState-> { return 6}
                resources.getDrawable(R.drawable.c7,null).constantState-> { return 7}
                resources.getDrawable(R.drawable.c8,null).constantState -> { return 8}
                resources.getDrawable(R.drawable.c9,null).constantState-> { return 9}
                resources.getDrawable(R.drawable.c10,null).constantState-> { return 10}
                resources.getDrawable(R.drawable.c11,null).constantState-> { return 11}
                resources.getDrawable(R.drawable.c12,null).constantState-> { return 12}
                resources.getDrawable(R.drawable.c13,null).constantState-> { return 13}
                else -> {return 0 }

            }

        }


}