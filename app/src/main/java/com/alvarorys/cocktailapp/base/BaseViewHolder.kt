package com.alvarorys.cocktailapp.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView
//bindea los items y la position de los items en el recycler view
abstract class BaseViewHolder<T>(itemView: View): RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item : T,position:Int)
}