package com.example.agrupacionmarilyn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.core.widget.doAfterTextChanged
import kotlinx.android.synthetic.main.activity_recycler_view.*

class SearchActivity : AppCompatActivity() {
    lateinit var buttonBuscar: AppCompatButton
    lateinit var editTextBuscador: EditText
    lateinit var recyclerViewActivity: RecyclerViewActivity
    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    val databaseController = DatabaseController(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        var location = intent.getStringExtra("location")

        buttonBuscar = findViewById(R.id.buttonBuscar)
        editTextBuscador = findViewById(R.id.buscador)

        buttonBuscar.setOnClickListener {
            val intent = Intent(this, RecyclerViewActivity::class.java)
            intent.putExtra("location", location)
            intent.putExtra("productoBuscado", editTextBuscador.text.toString())
            startActivity(intent)

        }

        toolbar = findViewById(R.id.toolbar2)
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