package com.example.calculadora

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.view.View.OnLongClickListener
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener, OnLongClickListener {

    private lateinit var binding: ActivityMainBinding

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
        binding.buttonMinus.setOnClickListener(this)
        binding.buttonMulti.setOnClickListener(this)
        binding.buttonDiv.setOnClickListener(this)

        //asignamos implementacion longclick

        binding.buttonAC.setOnLongClickListener(this)


    }

    // Implementamos la interfaz onclick, un when distribuye la accion del clik

    override fun onClick(p0: View ) {

        when (p0.id) {

            binding.button0.id -> {

                val registro = binding.primaryScreen.text.toString()
                binding.primaryScreen.text = registro + '0'

            }

            binding.button1.id -> {

                val registro = binding.primaryScreen.text.toString()
                binding.primaryScreen.text = registro + '1'
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

                if (!parseableDouble(binding.primaryScreen.text.toString())) {

                    binding.primaryScreen.text = "+"
                } else if (binding.secondaryScreen.text.isEmpty()) {

                    val registro = binding.primaryScreen.text
                    binding.secondaryScreen.text = registro
                    binding.primaryScreen.text = "+"

                } else {
                    val registro = binding.primaryScreen.text.toString().toDouble()
                    val registro2 = binding.secondaryScreen.text.toString().toDouble()

                    binding.secondaryScreen.text = (registro + registro2).toString()
                    binding.primaryScreen.text = "+"

                }


            }

            binding.buttonMinus.id -> {

                if (!parseableDouble(binding.primaryScreen.text.toString())) {

                    binding.primaryScreen.text = "-"
                } else if (binding.secondaryScreen.text.isEmpty()) {

                    val registro = binding.primaryScreen.text
                    binding.secondaryScreen.text = registro
                    binding.primaryScreen.text = "-"

                } else {
                    val registro = binding.primaryScreen.text.toString().toDouble()
                    val registro2 = binding.secondaryScreen.text.toString().toDouble()

                    binding.secondaryScreen.text = (registro2 + registro).toString()
                    binding.primaryScreen.text = "-"

                }

            }

            binding.buttonMulti.id -> {

                if (binding.primaryScreen.text.contains('*') || binding.primaryScreen.text.contains(
                        '/'
                    )
                ) {
                    binding.primaryScreen.text = binding.primaryScreen.text.removeRange(0, 1)
                }

                if (!parseableDouble(binding.primaryScreen.text.toString())) {

                    binding.primaryScreen.text = "*"
                } else if (binding.secondaryScreen.text.isEmpty()) {

                    val registro = binding.primaryScreen.text
                    binding.secondaryScreen.text = registro
                    binding.primaryScreen.text = "*"

                } else {
                    val registro = binding.primaryScreen.text.toString().toDouble()
                    val registro2 = binding.secondaryScreen.text.toString().toDouble()

                    binding.secondaryScreen.text = (registro2 * registro).toString()
                    binding.primaryScreen.text = "*"

                }

            }

            binding.buttonDiv.id -> {

                if (binding.primaryScreen.text.contains('*') || binding.primaryScreen.text.contains(
                        '/'
                    )
                ) {
                    binding.primaryScreen.text = binding.primaryScreen.text.removeRange(0, 1)
                }

                if (!parseableDouble(binding.primaryScreen.text.toString())) {

                    binding.primaryScreen.text = "/"
                } else if (binding.secondaryScreen.text.isEmpty()) {

                    val registro = binding.primaryScreen.text
                    binding.secondaryScreen.text = registro
                    binding.primaryScreen.text = "/"

                } else {
                    val registro = binding.primaryScreen.text.toString().toDouble()
                    val registro2 = binding.secondaryScreen.text.toString().toDouble()

                    binding.secondaryScreen.text = (registro2 / registro).toString()
                    binding.primaryScreen.text = "/"

                }

            }


            binding.buttonAC.id -> {

                if (binding.primaryScreen.text.toString().isEmpty() && binding.secondaryScreen.text.isEmpty()) {

                    binding.secondaryScreen.text="0"
                }

                else if (binding.primaryScreen.toString().isEmpty()){


                }

                else if (binding.primaryScreen.text.first() == '+') {

                    val registro = binding.primaryScreen.text.toString().toDouble()
                    val registro2 = binding.secondaryScreen.text.toString().toDouble()

                    binding.secondaryScreen.text = (registro2 + registro).toString()
                    binding.primaryScreen.text = ""


                }

                else if(binding.primaryScreen.text.first() == '-') {

                    val registro = binding.primaryScreen.text.toString().toDouble()
                    val registro2 = binding.secondaryScreen.text.toString().toDouble()

                    binding.secondaryScreen.text = (registro2 + registro).toString()
                    binding.primaryScreen.text = ""


                }

                else if(binding.primaryScreen.text.first() == '*') {

                    binding.primaryScreen.text = binding.primaryScreen.text.removeRange(0,1)

                    val registro = binding.primaryScreen.text.toString().toDouble()
                    val registro2 = binding.secondaryScreen.text.toString().toDouble()

                    binding.secondaryScreen.text = (registro * registro2).toString()
                    binding.primaryScreen.text = ""


                }

                else if(binding.primaryScreen.text.first() == '/') {

                    binding.primaryScreen.text = binding.primaryScreen.text.removeRange(0,1)

                    val registro = binding.primaryScreen.text.toString().toDouble()
                    val registro2 = binding.secondaryScreen.text.toString().toDouble()

                    binding.secondaryScreen.text = (registro2 / registro).toString()
                    binding.primaryScreen.text = ""

                }

                else { binding.secondaryScreen.text = binding.primaryScreen.text.toString()
                    binding.primaryScreen.text=""}







            }
        }
    }

    override fun onLongClick(p0: View?): Boolean {

        binding.primaryScreen.text = ""
        binding.secondaryScreen.text = ""
        return true
    }

    fun parseableDouble(str: String): Boolean {
        try {
            str.toDouble()
            return true
        } catch (e: NumberFormatException) {
            return false
        }
    }


}



