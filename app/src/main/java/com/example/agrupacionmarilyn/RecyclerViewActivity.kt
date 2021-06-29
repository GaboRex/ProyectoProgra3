package com.example.agrupacionmarilyn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    private lateinit var placeOptionsList: MutableList<Lugares>
    val databaseController = DatabaseController(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        recyclerView = findViewById(R.id.recyclerView)

        val adapter = OptionRecyclerViewAdapter(this, placeOptionsList)
        val layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager

        adapter.setOnMenuOptionClickListener { placeOption ->
            Toast.makeText(this, "Click en ${placeOption.nombre}", Toast.LENGTH_SHORT).show()
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

    fun mostrarLugares(zona: String){
            placeOptionsList = databaseController.obtenerLugares(zona)
    }
}