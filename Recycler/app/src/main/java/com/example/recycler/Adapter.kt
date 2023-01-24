package com.example.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter (val contexto: Context, val listadatos: ArrayList <Coches>) : RecyclerView.Adapter <Adapter.MyHolder> () {


    inner class MyHolder(vista:View) : RecyclerView.ViewHolder(vista) {

        var imagen: ImageView
        var nombre: TextView
        var detalle: TextView

        init {
            imagen = itemView.findViewById(R.id.imageCoche)
            nombre = itemView.findViewById(R.id.textViewNombre)
            detalle = itemView.findViewById(R.id.textViewDetalles)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {

        val vista = LayoutInflater.from(contexto).inflate(R.layout.recycler_view,parent,false)
        return MyHolder(vista)


    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        val tempcoche : Coches = listadatos[position]
        holder.nombre.text = tempcoche.nombre
        holder.detalle.text = "Detalle"
        holder.imagen.setImageResource(tempcoche.img)


    }

    override fun getItemCount(): Int {

        return listadatos.size
    }


}