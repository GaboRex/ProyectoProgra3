package com.example.agrupacionmarilyn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.net.toUri

class ProductoLugar_Activity : AppCompatActivity() {
    lateinit var buttonDirecciones: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producto_lugar)
        val databaseController = DatabaseController(this)

        var nombreLugar = intent.getStringExtra("nombreLugar")
        var nroProducto = intent.getStringExtra("nroProducto")
        var nombreProducto = intent.getStringExtra("nombreProducto")

        val nombreLugarText: TextView = findViewById(R.id.textViewNombre)
        val nombreProductoText: TextView = findViewById(R.id.textViewNombreP)
        val imagenLugarView: ImageView = findViewById(R.id.imageViewLugar)
        val descripcionText: TextView = findViewById(R.id.textViewDescripcion)

        nombreLugarText.text = nombreLugar
        nombreProductoText.text = nombreProducto
        //descripcionText.text = databaseController.obtenerDescripcion(nombreProducto!!)
        //imagenLugarView.setImageDrawable()

        //Toast.makeText(this, "${databaseController.obtenerDescripcion(nombreProducto!!)}", Toast.LENGTH_LONG).show()
        //Toast.makeText(this, "Latitud ${databaseController.obtenerLatitud(nombreLugar!!, "Achumani")}", Toast.LENGTH_LONG).show()
        //Toast.makeText(this, "Longitud ${databaseController.obtenerLongitud(nombreLugar!!, "Achumani")}", Toast.LENGTH_SHORT).show()

        buttonDirecciones = findViewById(R.id.buttonContinuar)

        buttonDirecciones.setOnClickListener {
            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
        }
    }
}