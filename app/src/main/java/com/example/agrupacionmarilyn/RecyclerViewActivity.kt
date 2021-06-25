package com.example.agrupacionmarilyn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var toolbar: androidx.appcompat.widget.Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        recyclerView = findViewById(R.id.recyclerView)

        val placeOptionsList = mutableListOf(
            PlaceOption("Ketal", R.drawable.ketal, "Supermercado"),
            PlaceOption("Hipermaxi", R.drawable.hipermaxi, "Supermercado"),
            PlaceOption("Fidalga", R.drawable.fidalga, "Supermercado")
        )

        val adapter = OptionRecyclerViewAdapter(this, placeOptionsList)
        val layoutManager = LinearLayoutManager(this)
//        val layoutManager = GridLayoutManager(this, 2)
//        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager

        adapter.setOnMenuOptionClickListener { placeOption ->
            Toast.makeText(this, "Click en ${placeOption.titulo}", Toast.LENGTH_SHORT).show()
            /*if(menuOption.titulo == "Tienda") {
                val intent = Intent(this, TiendaActivity::class.java)
                startActivity(intent)
            }*/
        }

        toolbar = findViewById(R.id.toolbar5)
        toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_item_acerca_de -> {
                    Toast.makeText(this, "Click en Acerca de", Toast.LENGTH_SHORT).show()
                }
                R.id.menu_item_perfil -> {
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                }
            }
            true
        }
    }
}