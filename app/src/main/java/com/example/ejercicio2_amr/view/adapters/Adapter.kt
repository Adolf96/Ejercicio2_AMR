package com.example.ejercicio2_amr.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ejercicio2_amr.databinding.StarwElementBinding
import com.example.ejercicio2_amr.model.StarWpeople

class Adapter(private val contexto: Context, private val stwars: ArrayList<StarWpeople>): RecyclerView.Adapter<Adapter.ViewHolder>(){

    class ViewHolder(view: StarwElementBinding): RecyclerView.ViewHolder(view.root) {
        val tvNombre = view.tvNombre



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = StarwElementBinding.inflate(LayoutInflater.from(contexto))
        return  ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvNombre.text = stwars[position].

    }

    override fun getItemCount(): Int =stwars.size

}
