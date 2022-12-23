package com.example.ejercicio2_amr.model

import com.google.gson.annotations.SerializedName

data class StarWmovie(
    @SerializedName("films")
    var films: String? = null
)
