package br.com.mizaeldouglas.api_mvp.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    fun getJsonPlace(): JsonPlaceApi {
        val gson = GsonBuilder().create()
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(JsonPlaceApi::class.java)

    }
}