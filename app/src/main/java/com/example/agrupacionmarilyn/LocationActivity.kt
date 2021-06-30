package com.example.agrupacionmarilyn

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class LocationActivity : AppCompatActivity(){
    lateinit var buttonContinuar: Button
    lateinit var spinner: Spinner
    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    val databaseController = DatabaseController(this)
    val listaLugares = RecyclerViewActivity()

    val listOfLocations = listOf("Achumani", "Calacoto", "Cota Cota", "Irpavi", "Los Pinos", "Mallasa",
        "Miraflores", "Obrajes", "San Miguel", "San Pedro", "Sopocachi")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)

        buttonContinuar = findViewById(R.id.buttonContinuar)
        spinner = findViewById(R.id.spinner)

        buttonContinuar.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listOfLocations)
        spinner.adapter = adapter

        /*spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long) {
                listaLugares.mostrarLugares(adapter.getItem(pos)!!)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }*/

        toolbar = findViewById(R.id.toolbar)
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