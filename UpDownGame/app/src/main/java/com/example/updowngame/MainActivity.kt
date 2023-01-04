package com.example.updowngame

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.updowngame.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonEmpezar.setOnClickListener() {

            if (nameIntroduced()) {

                val nombre : String = binding.textImput.text.toString()
                val intent = Intent(this, GameActivity::class.java)
                intent.putExtra("nombre", nombre)
                startActivity(intent)

            }

        }


    }

    //Funcion para show Toast si no esta introducido el nombre
    fun nameIntroduced(): Boolean {

        if (binding.textImput.text.isEmpty()) {

            Toast.makeText(this, R.string.warning, Toast.LENGTH_LONG).show()
            return false
        }

        else return true

    }
}