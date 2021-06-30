package com.example.agrupacionmarilyn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class ProductoLugar_Activity : AppCompatActivity() {
    val databaseController = DatabaseController(this)
    lateinit var buttonMap: Button
    lateinit var toolbar: androidx.appcompat.widget.Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producto_lugar)

        var nomLugar = intent.getStringExtra("nombreLugar")
        var nomProducto = intent.getStringExtra("nombreProducto")

        var nombreLugar: TextView = findViewById(R.id.textViewNombre)
        var nombreProducto: TextView = findViewById(R.id.textViewProducto)

        nombreLugar.text = nomLugar
        nombreProducto.text = nomProducto

        //Toast.makeText(this, "Latitud ${databaseController.obtenerLatitud(nomLugar, "Achumani")}", Toast.LENGTH_SHORT).show()
        //Toast.makeText(this, "Longitud ${databaseController.obtenerLongitud(nomLugar, "Achumani")}", Toast.LENGTH_SHORT).show()

        buttonMap = findViewById(R.id.buttonMap)

        buttonMap.setOnClickListener {
            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
        }

        toolbar = findViewById(R.id.toolbarLista)
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