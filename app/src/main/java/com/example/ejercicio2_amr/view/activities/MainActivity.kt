package com.example.ejercicio2_amr.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejercicio2_amr.databinding.ActivityMainBinding
import com.example.ejercicio2_amr.util.Constants
import com.example.ejercicio2_amr.view.adapters.Adapter
import com.example.ejercicio2_amr.view.model.People
import com.example.ejercicio2_amr.view.model.StarWapi
import com.example.ejercicio2_amr.view.model.StarWpeople
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
                    for(people in response.body()?.people!!){
                        Log.d(Constants.LOGTAG, "${people.name}")
                        Log.d(Constants.LOGTAG, "${people.height}")
                        Log.d(Constants.LOGTAG, "${people.birth_year}")
                        Log.d(Constants.LOGTAG, "${people.gender}")
                    }

                    /*val starwTmp: StarWpeople

                    for(starwTmp in response.body()?.people!!){
                        Toast.makeText(this@MainActivity, "Nombre del personaje: ${starwTmp.name}", Toast.LENGTH_SHORT).show()
                    }*/

                    binding.rvMenu.layoutManager = LinearLayoutManager(this@MainActivity)
                    binding.rvMenu.adapter = Adapter(this@MainActivity, response.body()?.people!!)

                    binding.pbConexion.visibility = View.GONE

                }

                override fun onFailure(call: Call<StarWpeople>, t: Throwable) {
                    binding.pbConexion.visibility = View.GONE
                    Toast.makeText(this@MainActivity, "Error de conexión: ${t.message}", Toast.LENGTH_SHORT).show()

                }

            })

        }
    }

    fun selectOption(people: People) {

    }
}