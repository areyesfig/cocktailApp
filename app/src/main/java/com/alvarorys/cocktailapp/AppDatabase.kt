package com.alvarorys.cocktailapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.alvarorys.cocktailapp.data.model.DrinkEntity
import com.alvarorys.cocktailapp.domain.TragosDao

//esta clase va a ser el punto de partida para poner los datos y ir a buscar informacion

@Database(entities = arrayOf(DrinkEntity::class),version = 1)
abstract class AppDatabase: RoomDatabase(){

    //cuando genere la instacncia de app database
    abstract fun tragoDao(): TragosDao


    //tenemos que crear un singleton para que percista la misma instancia en toda la aplicacion
    companion object{
        //preguta por las instancias si no es nula crea la instancia
        private var INSTANCE : AppDatabase? = null

        fun getDatabase(context: Context):AppDatabase{
            //si es nulla tiene que crear la instancia del builder para que la pueda ocupar siempre la misma
            INSTANCE = INSTANCE ?: Room.databaseBuilder(context.applicationContext,AppDatabase::class.java,"tabla_tragos").build()
            return INSTANCE!!
        }

        fun destroyInstance(){
            INSTANCE = null
        }

    }
}