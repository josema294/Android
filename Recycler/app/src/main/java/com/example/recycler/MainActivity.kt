package com.example.recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptador: Adapter
    private lateinit var listaCoches: ArrayList <Coches>

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val mercedes = Coches ("Mercedes","AMG GT",500,200000,"Deportivo",  R.drawable.amggt)
        val bentley = Coches( "Bentley","Continental",400,300000,"Berlina deportivo", R.drawable.continental)
        val jaguar = Coches("Jaguar","FType",300,150000,"Deportivo", R.drawable.ftype)
        val ford = Coches( "Ford","GT40",500,300000,"Deportivo clasico", R.drawable.gt40)
        val nisaan = Coches(  "Nissan","GTR",300,200000,"Deportivo", R.drawable.gtr)
        val porsche = Coches(  "Porche","Huayara",600,400000,"Deportivo", R.drawable.huayra)
        val lexus = Coches( "Lexus","LC",200,100000,"Deportivo", R.drawable.lc)
        val ferrari = Coches( "Ferrari","Le ferrari",600,500000,"Deportivo", R.drawable.leferrari)
        val mclaren = Coches("McLaren","MC600",500,450000,"Deportivo", R.drawable.mc600)
        val toyota = Coches(  "Toyota","Supra",300,150000,"Deportivo", R.drawable.supra)
        val porscheElectrico = Coches( "Porche","Taycan",350,250000,"Deportivo", R.drawable.taycan)


        listaCoches = ArrayList()
        listaCoches.add(bentley)
        listaCoches.add(ford)
        listaCoches.add(porsche)
        listaCoches.add(lexus)
        listaCoches.add(ferrari)
        listaCoches.add(mclaren)
        listaCoches.add(toyota)
        listaCoches.add(porscheElectrico)

        adaptador = Adapter(applicationContext, listaCoches)
        binding.recyclerCoches.adapter = adaptador
        binding.recyclerCoches.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)




    }


}