package com.example.ejercicio2_amr.view.model

import com.google.gson.annotations.SerializedName

data class StarWmovie(
    @SerializedName("films")
    var films: String? = null
)
