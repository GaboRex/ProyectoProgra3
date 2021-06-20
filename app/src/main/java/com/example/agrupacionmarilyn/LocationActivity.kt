package com.example.agrupacionmarilyn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class LocationActivity : AppCompatActivity() {
    var buttonContinuar: Button? = null
    lateinit var spinner: Spinner
    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    val listOfLocations = listOf("Achumani", "Calacoto", "Los Pinos")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)

        buttonContinuar = findViewById(R.id.buttonContinuar)
        spinner = findViewById(R.id.spinner)

        buttonContinuar?.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listOfLocations)
        spinner.adapter = adapter

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