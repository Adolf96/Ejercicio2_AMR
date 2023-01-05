package com.example.ejercicio2_amr.model

import com.google.gson.annotations.SerializedName

data class StarWpeople(

    @SerializedName("results")
    var people: ArrayList<People>? = null

)

class People {
    @SerializedName("name")
    var name: String? = null

    @SerializedName("height")
    var height: String? = null

    @SerializedName("birth_year")
    var birth_year: String? = null

    @SerializedName("gender")
    var gender: String? = null

}
