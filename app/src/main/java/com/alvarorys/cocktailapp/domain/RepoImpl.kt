package com.alvarorys.cocktailapp.domain

import com.alvarorys.cocktailapp.data.DataSource
import com.alvarorys.cocktailapp.data.model.Drink
import com.alvarorys.cocktailapp.vo.Resource

class RepoImpl(private val dataSource: DataSource) : Repo {
    suspend override fun getTragosList(tragoName:String): Resource<List<Drink>> {
        return dataSource.getTragoByName(tragoName)
    }
}