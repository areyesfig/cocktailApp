package com.alvarorys.cocktailapp.domain

import com.alvarorys.cocktailapp.data.model.Drink
import com.alvarorys.cocktailapp.vo.Resource

interface Repo {

    suspend fun getTragosList(tragoName:String): Resource<List<Drink>>
}