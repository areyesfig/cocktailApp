package com.alvarorys.cocktailapp.domain

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alvarorys.cocktailapp.data.model.DrinkEntity
@Dao
interface TragosDao {

    @Query("SELECT * FROM tragosEntity")
    suspend fun getAllFavoriteDrinks():List<DrinkEntity>

    //cuando tenga un conflictos con id quiero que lo remplace , de ea forma hacemos una insert seguro
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(trago:DrinkEntity)
}