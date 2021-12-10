package Retrofit

import Model.Valyuta
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("json")
    fun getValyuta():Call<List<Valyuta>>
}