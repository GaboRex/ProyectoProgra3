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
    lateinit var productoABuscar: String
    val databaseController = DatabaseController(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        var zona = intent.getStringExtra("location")
        var producto = intent.getStringExtra("productoBuscado")

        recyclerView = findViewById(R.id.recyclerView)

        val adapter = OptionRecyclerViewAdapter(this, databaseController.obtenerLugaresPorZona(producto.toString(), zona.toString()))
        val layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager

        adapter.setOnMenuOptionClickListener { placeOption ->
            Toast.makeText(this, "Click en ${placeOption.nombre}", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ProductoLugar_Activity::class.java)
            intent.putExtra("nombreLugar", placeOption.nombre)
            intent.putExtra("nroProducto", placeOption.nro_producto)
            intent.putExtra("nombreProducto", producto)
            startActivity(intent)
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