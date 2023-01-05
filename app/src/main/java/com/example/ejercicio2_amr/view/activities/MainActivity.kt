package com.example.ejercicio2_amr.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.ejercicio2_amr.databinding.ActivityMainBinding
import com.example.ejercicio2_amr.model.StarWapi
import com.example.ejercicio2_amr.model.StarWpeople
import com.example.ejercicio2_amr.util.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        CoroutineScope(Dispatchers.IO).launch {
            val call = Constants.getRetrofit(). create(StarWapi::class.java).getStarWpeople("api/people")
            call.enqueue(object: Callback<StarWpeople> {
                override fun onResponse(
                    call: Call<StarWpeople>,
                    response: Response<StarWpeople>
                ) {
                    Log.d(Constants.LOGTAG, "Respuesta del servidor: ${response.toString()} ")
                    Log.d(Constants.LOGTAG, "Datos: ${response.body().toString()} ")
                    binding.pbConexion.visibility = View.GONE

                }

                override fun onFailure(call: Call<StarWpeople>, t: Throwable) {
                    binding.pbConexion.visibility = View.GONE
                    Toast.makeText(this@MainActivity, "Error de conexión: ${t.message}", Toast.LENGTH_SHORT).show()

                }

            })

        }
    }
}