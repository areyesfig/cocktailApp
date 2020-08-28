package com.alvarorys.cocktailapp.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alvarorys.cocktailapp.R
import com.alvarorys.cocktailapp.base.BaseViewHolder
import com.alvarorys.cocktailapp.data.model.Drink
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.tragos_row.view.*

class MainAdaptar(
    private val context: Context,
    private val tragosList: List<Drink>,
    private val itemClickListener: OnTragoClickListener
) :
    RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnTragoClickListener {
        fun onTragoClick(drink: Drink)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return MainViewHolder(
            LayoutInflater.from(context).inflate(R.layout.tragos_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is MainViewHolder -> holder.bind(tragosList[position], position)
        }
    }

    override fun getItemCount(): Int {
        return tragosList.size
    }

    //evita que cuando se detruya el ciclo de este fragment muera todo lo que contiene y no genera leaks de memoria en nuestra app
    //usa los atributos del constructor principal

    inner class MainViewHolder(itemView: View) : BaseViewHolder<Drink>(itemView) {
        override fun bind(item: Drink, position: Int) {
            Glide.with(context).load(item.imagen).centerCrop().into(itemView.img_trago)
            itemView.txt_titulo.text = item.nombre
            itemView.txt_descripcion.text = item.descripcion
            itemView.setOnClickListener{ itemClickListener.onTragoClick(item)}
        }

    }
}