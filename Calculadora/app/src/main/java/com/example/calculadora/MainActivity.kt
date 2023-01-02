
package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.view.View.OnLongClickListener
import androidx.appcompat.app.AlertDialog
import androidx.core.view.ViewCompat
import com.example.calculadora.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), OnClickListener, OnLongClickListener    {

    private lateinit var binding: ActivityMainBinding


    //private var primaryScreenValue: String = ""
    //private var secondaryScreenValue : Double = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)


        //Asignamos implemetacion de onclick a el listener de cada boton.
        binding.button0.setOnClickListener(this)
        binding.button1.setOnClickListener(this)
        binding.button2.setOnClickListener(this)
        binding.button3.setOnClickListener(this)
        binding.button4.setOnClickListener(this)
        binding.button5.setOnClickListener(this)
        binding.button6.setOnClickListener(this)
        binding.button7.setOnClickListener(this)
        binding.button8.setOnClickListener(this)
        binding.button9.setOnClickListener(this)
        binding.buttonAC.setOnClickListener(this)
        binding.buttoncomm.setOnClickListener(this)
        binding.buttonPlus.setOnClickListener(this)

        //asignamos implementacion longclick

        binding.buttonAC.setOnLongClickListener(this)



        // binding.secondaryScreen.text = secondaryScreenValue.toString()




    }

    // Implementamos la interfaz onclick, un when distribuye la accion del clik

    override fun onClick(p0: View) {


        when (p0.id) {

            binding.button0.id -> {

                val registro = binding.primaryScreen.text.toString()
                binding.primaryScreen.text = registro+'0'

            }

            binding.button1.id -> {

                val registro = binding.primaryScreen.text.toString()
                binding.primaryScreen.text = registro+ '1'
            }
            binding.button2.id -> {

                val registro = binding.primaryScreen.text.toString()
                binding.primaryScreen.text = registro + '2'
            }
            binding.button3.id -> {

                val registro = binding.primaryScreen.text.toString()
                binding.primaryScreen.text = registro + '3'
            }
            binding.button4.id -> {

                val registro = binding.primaryScreen.text.toString()
                binding.primaryScreen.text = registro + '4'
            }
            binding.button5.id -> {

                val registro = binding.primaryScreen.text.toString()
                binding.primaryScreen.text = registro + '5'
            }
            binding.button6.id -> {

                val registro = binding.primaryScreen.text.toString()
                binding.primaryScreen.text = registro + '6'
            }
            binding.button7.id -> {

                val registro = binding.primaryScreen.text.toString()
                binding.primaryScreen.text = registro + '7'
            }
            binding.button8.id -> {

                val registro = binding.primaryScreen.text.toString()
                binding.primaryScreen.text = registro + '8'
            }
            binding.button9.id -> {

                val registro = binding.primaryScreen.text.toString()
                binding.primaryScreen.text = registro + '9'
            }


            binding.buttoncomm.id -> {

                if (binding.primaryScreen.text.isEmpty()) {

                    binding.primaryScreen.text = "0."

                }

                if (binding.primaryScreen.text.contains('.'))

                //Si ya existe '.' no se pone otra al numero

                else binding.primaryScreen.text = binding.primaryScreen.text.toString() + "."
            }

            binding.buttonPlus.id -> {

                if (binding.secondaryScreen.text.isEmpty()) {

                    val registro = binding.primaryScreen.text
                    binding.secondaryScreen.text = registro
                    binding.primaryScreen.text = "+"

                }

                else {
                    val registro = binding.primaryScreen.text.toString().toDouble()
                    val registro2 = binding.secondaryScreen.text.toString().toDouble()

                    binding.secondaryScreen.text = (registro + registro2).toString()
                    binding.primaryScreen.text = "+"

                }




            }


            binding.buttonAC.id -> {

                if (binding.primaryScreen.text.isEmpty()) {
                    binding.secondaryScreen.text = "0"
                }

                //
                if (binding.primaryScreen.text.contains('+')) {

                    var operador1 = binding.primaryScreen.text.trimStart().toString().toDouble()
                    var operador2 = binding.secondaryScreen.text.toString().toDouble()

                    val registro = operador1 + operador2
                    binding.secondaryScreen.text = registro.toString()
                    binding.primaryScreen.text= ""

                }

                if (binding.secondaryScreen.text.isEmpty()) {
                    binding.secondaryScreen.text = binding.primaryScreen.text
                    binding.primaryScreen.text= ""
                }




            }

        }


    }

    override fun onLongClick(p0: View?) : Boolean {

        binding.primaryScreen.text = ""
        binding.secondaryScreen.text = ""
        return true
    }


}



