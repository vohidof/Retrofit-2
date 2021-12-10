package com.vohidov.retrofit2

import Model.Valyuta
import Retrofit.Common
import Retrofit.RetrofitService
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.vohidov.retrofit2.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var retrofitService: RetrofitService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        retrofitService = Common.retrofitService(this)

        retrofitService.getValyuta().enqueue(object : Callback<List<Valyuta>> {
            override fun onResponse(call: Call<List<Valyuta>>, response: Response<List<Valyuta>>) {
                if (response.isSuccessful) {
                    binding.txtValyuta.text = response.body().toString()
                }
            }

            override fun onFailure(call: Call<List<Valyuta>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "", Toast.LENGTH_SHORT).show()
            }
        })
    }
}