package com.alvarorys.cocktailapp.vo

import com.alvarorys.cocktailapp.domain.WebService
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


//va a crear una instancia de retrofit para poder trabajar con la url base
object RetrofitClient {

    val webservice by lazy {
        Retrofit.Builder()
            .baseUrl("https://www.thecocktaildb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))  //mecanismo para convertir ese json array a un objeto que cree en la app
            .build().create(WebService::class.java)
    }
}