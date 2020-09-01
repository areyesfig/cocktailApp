package com.alvarorys.cocktailapp.ui.viewmodel

import androidx.lifecycle.*
import com.alvarorys.cocktailapp.data.model.DrinkEntity
import com.alvarorys.cocktailapp.domain.Repo
import com.alvarorys.cocktailapp.vo.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel(private val repo:Repo):ViewModel() {
    //escribimos un string como entorno de busqueda que es el nombre del trago
    private val tragosData = MutableLiveData<String>()

    //le hacemos un setup al mutable live data de un string que es el nombre del trago
    fun setTrago(tragoName: String) {
        tragosData.value = tragoName
    }

    //apenas inicie la aplicacion quiero que me cargue los tragos por defecto
    init {
        setTrago("margarita")
    }

    //si buscamos un valor y volvemmos a buscar el mismo , no va a buscar datos si no es distinto al ult con distinc
    val fetchTragosList = tragosData.distinctUntilChanged().switchMap { nombreTrago ->
        liveData(Dispatchers.IO) {
            emit(Resource.Loading())
            try {
                emit(repo.getTragosList(nombreTrago))
            } catch (e: Exception) {
                emit(Resource.Failure(e))
            }

        }
    }

    fun guardarTrago(trago: DrinkEntity) {
        //cuando la activity que contiene los fregmant se destruya este vm pasa por un on clear y automaticamente va
        // a limpiar cualquier objeto y proceso que quede en memoria, el laun estamos dando un context de courutina
        viewModelScope.launch {
            repo.insertTrago(trago)//pasa el trago que acabo de poner en esa interfaz de favorito
        }
    }

    fun getTragosFavoritos() = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(repo.getTragosFavoritos())
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }
}