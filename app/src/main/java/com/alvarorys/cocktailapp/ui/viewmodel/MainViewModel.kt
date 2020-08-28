package com.alvarorys.cocktailapp.ui.viewmodel

import androidx.lifecycle.*
import com.alvarorys.cocktailapp.domain.Repo
import com.alvarorys.cocktailapp.vo.Resource
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class MainViewModel(private val repo:Repo):ViewModel() {
    //escribimos un string como entorno de busqueda que es el nombre del trago
    private val tragosData = MutableLiveData<String>()

    //le hacemos un setup al mutable live data de un string que es el nombre del trago
    fun setTrago(tragoName:String){
        tragosData.value = tragoName
    }

    //apenas inicie la aplicacion quiero que me cargue los tragos por defecto
    init {
        setTrago("margarita")
    }

    //si buscamos un valor y volvemmos a buscar el mismo , no va abuscar datos si no es distinto al ult con distinc
    val fetchTragosList = tragosData.distinctUntilChanged().switchMap {nombreTrago ->
        liveData(Dispatchers.IO) {
            emit(Resource.Loading())
            try {
                emit(repo.getTragosList(nombreTrago))
            }catch (e: Exception){
                emit(Resource.Failure(e))
            }

        }
    }
}