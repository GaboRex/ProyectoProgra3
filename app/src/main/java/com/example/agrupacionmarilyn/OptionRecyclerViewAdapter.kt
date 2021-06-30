package com.example.agrupacionmarilyn

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OptionRecyclerViewAdapter(val context: Context, val list: MutableList<Lugares>): RecyclerView.Adapter<OptionsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionsViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val itemListView = layoutInflater.inflate(R.layout.layout_options_list_item, parent, false)
        return OptionsViewHolder(itemListView)
    }

    var funcionPlaceOptionClick: ((lugares: Lugares) -> Unit)? = null

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

    fun setOnMenuOptionClickListener(funcion: (lugares: Lugares) -> Unit) {
        funcionPlaceOptionClick = funcion
    }
}

class OptionsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val textViewTitulo: TextView = itemView.findViewById(R.id.textViewTitulo)
    val textViewSubtitulo: TextView = itemView.findViewById(R.id.textViewSubtitulo)
    val imageView: ImageView = itemView.findViewById(R.id.imageView)
    val imageButton: ImageButton = itemView.findViewById(R.id.imageButton)

    fun bind(lugares: Lugares) {
        textViewTitulo.text = lugares.nombre
        textViewSubtitulo.text = lugares.tipoDeLugar
        //imageView.setImageResource()
    }
}