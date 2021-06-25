package com.example.agrupacionmarilyn

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OptionRecyclerViewAdapter(val context: Context, val list: List<PlaceOption>): RecyclerView.Adapter<OptionsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionsViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val itemListView = layoutInflater.inflate(R.layout.layout_options_list_item, parent, false)
        return OptionsViewHolder(itemListView)
    }

    var funcionPlaceOptionClick: ((menuOption: PlaceOption) -> Unit)? = null

    override fun onBindViewHolder(holder: OptionsViewHolder, position: Int) {
        holder.bind(list[position])
        holder.imageButton.setOnClickListener {
            funcionPlaceOptionClick?.invoke(list[position])
        }

        // En todo el elemento
//        holder.itemView.setOnClickListener {
//            funcionMenuOptionClick?.invoke(list[position])
//        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setOnMenuOptionClickListener(funcion: (placeOption: PlaceOption) -> Unit) {
        funcionPlaceOptionClick = funcion
    }
}

class OptionsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val textViewTitulo: TextView = itemView.findViewById(R.id.textViewTitulo)
    val textViewSubtitulo: TextView = itemView.findViewById(R.id.textViewSubtitulo)
    val imageView: ImageView = itemView.findViewById(R.id.imageView)
    val imageButton: ImageButton = itemView.findViewById(R.id.imageButton)

    fun bind(menuOption: PlaceOption) {
        textViewTitulo.text = menuOption.titulo
        textViewSubtitulo.text = menuOption.subtitulo
        imageView.setImageResource(menuOption.icono)
    }
}