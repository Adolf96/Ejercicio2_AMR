package com.example.ejercicio2_amr.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ejercicio2_amr.databinding.StarwElementBinding
import com.example.ejercicio2_amr.view.activities.MainActivity
import com.example.ejercicio2_amr.view.model.People

class Adapter(private val context: Context, private val stwars: ArrayList<People>): RecyclerView.Adapter<Adapter.ViewHolder>(){

    class ViewHolder(view: StarwElementBinding): RecyclerView.ViewHolder(view.root) {
        val tvNombre = view.tvNombre
        val tvAltura = view.tvAltura
        val tvNacimiento = view.tvNacimiento
        val tvGenero = view.tvGenero



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = StarwElementBinding.inflate(LayoutInflater.from(context))
        return  ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvNombre.text = stwars[position].name
        holder.tvAltura.text = stwars[position].height
        holder.tvNacimiento.text = stwars[position].birth_year
        holder.tvGenero.text = stwars[position].gender

        holder.itemView.setOnClickListener {
            if(context is MainActivity) context.selectOption(stwars[position])
        }

    }

    override fun getItemCount(): Int =stwars.size

}

