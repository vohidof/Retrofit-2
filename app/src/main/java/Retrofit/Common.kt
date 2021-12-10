package Retrofit

import android.content.Context

object Common {
    val BASE_URL = "https://cbu.uz/oz/arkhiv-kursov-valyut/"

    fun retrofitService(context: Context):RetrofitService {
        return RetrofitClient.getRetrofit(BASE_URL, context).create(RetrofitService::class.java)
    }
}