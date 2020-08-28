package com.alvarorys.cocktailapp.domain

import com.alvarorys.cocktailapp.data.model.DrinkList
import retrofit2.http.GET
import retrofit2.http.Query

//hacer diferentes consultas a la api especifica
interface WebService {

    @GET("search.php")
    suspend fun getTragoByNAme(@Query("s") tragoName:String): DrinkList  //viene de courutinas,le dice a la funcion que busque algo y cuando termine , retorne algo
}