package com.example.ejercicio2_amr.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface StarWapi {

    @GET()
    fun getStarWpeople(
        @Url url: String?
    ): Call<ArrayList<StarWpeople>>

    @GET("api/planets/{id}")
    fun getStarWplanet(
        @Path("id") id: String?
    ): Call<StarWplanet>


}