package com.alvarorys.cocktailapp.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Drink(
    @SerializedName("strDrinkThumb")//marca el nombre que esta en la base de datos
    val imagen: String = "",

    @SerializedName("strDrink")
    val nombre: String = "",

    @SerializedName("strInstructions")
    val descripcion: String ="",

    @SerializedName("strAlcoholic")
    val hasAlcohol:String = "Non_Alcoholic"


) : Parcelable

//necesitamos una clase que contenga la lista del endpoint
//ponemos el nombre del array principal para que busque toda la lista de tragos
data class DrinkList(
    @SerializedName("drinks")
    val drinkList:List<Drink>
)
//El objeto necesita los mismos campos del endpoint para traer los valores correspondientes

//estamos creando la entidad para que se vea reflejada en la tabla , como se almacena la info en sqlite
@Entity(tableName = "tragosEntity")
data class DrinkEntity(
    @PrimaryKey
    val tragoId: String,
    @ColumnInfo(name = "trago_imagen")
    val imagen: String = "",

    @ColumnInfo(name = "trago_nombre")
    val nombre: String = "",

    @ColumnInfo(name = "trago_descripcion")
    val descripcion: String ="",

    @ColumnInfo(name = "trago_has_alcohol")
    val hasAlcohol:String = "Non_Alcoholic"

)