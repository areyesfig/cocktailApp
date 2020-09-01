package com.alvarorys.cocktailapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.alvarorys.cocktailapp.AppDatabase
import com.alvarorys.cocktailapp.R
import com.alvarorys.cocktailapp.data.DataSource
import com.alvarorys.cocktailapp.domain.RepoImpl
import com.alvarorys.cocktailapp.ui.viewmodel.MainViewModel
import com.alvarorys.cocktailapp.ui.viewmodel.VMFactory
import com.alvarorys.cocktailapp.vo.Resource


class FavoritosFragment : Fragment() {

    private val viewModel by viewModels<MainViewModel> { VMFactory(RepoImpl(DataSource(AppDatabase.getDatabase(requireActivity().applicationContext)))) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favoritos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getTragosFavoritos().observe(viewLifecycleOwner, Observer { result ->
            when(result){
                is Resource.Loading -> {}
                is Resource.Success -> {
                    Log.d("Lista Favoritos","${result.data}")
                }
                is Resource.Failure -> {

                }
            }
        })
    }
}