package com.alvarorys.cocktailapp.data

import com.alvarorys.cocktailapp.AppDatabase
import com.alvarorys.cocktailapp.data.model.Drink
import com.alvarorys.cocktailapp.data.model.DrinkEntity
import com.alvarorys.cocktailapp.vo.Resource
import com.alvarorys.cocktailapp.vo.RetrofitClient

class DataSource(private val appDatabase: AppDatabase) {

    //todo metodo suspend tiene que ser llemado desde otro igual

    suspend fun getTragoByName(tragoName:String):Resource<List<Drink>>{
        return Resource.Success(RetrofitClient.webservice.getTragoByNAme(tragoName).drinkList)
    }

    suspend fun insertTragoIntoRoom(trago:DrinkEntity){
        appDatabase.tragoDao().insertFavorite(trago)
    }

    suspend fun getTragosFavoritos(): Resource<List<DrinkEntity>> {
        return Resource.Success(appDatabase.tragoDao().getAllFavoriteDrinks())
    }

}