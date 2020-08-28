package com.alvarorys.cocktailapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alvarorys.cocktailapp.R
import com.alvarorys.cocktailapp.data.model.Drink
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_tragos_detalle.*


class TragosDetalleFragment : Fragment() {

    private lateinit var drink: Drink


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireArguments().let {
            drink = it.getParcelable("drink")!!
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_tragos_detalle, container, false)
    }

    // para comenzar a inflar el layout con lo que voy recibiendo del otro fragment
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(requireContext()).load(drink.imagen).centerCrop().into(img_trago)
        trago_title.text = drink.nombre
        trago_descripcion.text = drink.descripcion
        if(drink.hasAlcohol.equals("Non_Alcoholic")){
            txt_has_alcohol.text = "Bebida sin alcohol"
        }else{
            txt_has_alcohol.text = "Bebida con alcohol"
        }


    }
}