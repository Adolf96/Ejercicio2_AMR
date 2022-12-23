package com.example.ejercicio2_amr.model

import com.google.gson.annotations.SerializedName

data class StarWplanet(
    @SerializedName("homeworld")
    var homeworld: Homeworld? = null
)

class Homeworld {

    @SerializedName("name")
    var name: String? = null

    @SerializedName("rotation_period")
    var rotation_period: String? = null

    @SerializedName("orbital_period")
    var orbital_period: String? = null

    @SerializedName("diameter")
    var diameter: String? = null

    @SerializedName("climate")
    var climate: String? = null

    @SerializedName("terrain")
    var terrain: String? = null

    @SerializedName("population")
    var population: String? = null

}
