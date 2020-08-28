package com.alvarorys.cocktailapp.data

import com.alvarorys.cocktailapp.data.model.Drink
import com.alvarorys.cocktailapp.vo.Resource
import com.alvarorys.cocktailapp.vo.RetrofitClient

class DataSource {

    //todo metodo suspend tiene que ser llemado desde otro igual

    suspend fun getTragoByName(tragoName:String):Resource<List<Drink>>{
        return Resource.Success(RetrofitClient.webservice.getTragoByNAme(tragoName).drinkList)
    }

}