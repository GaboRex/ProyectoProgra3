package com.example.agrupacionmarilyn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SearchActivity : AppCompatActivity() {
    var buttonBuscar: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        buttonBuscar = findViewById(R.id.buttonBuscar)

        buttonBuscar?.setOnClickListener {
            val intent = Intent(this, ListViewActivity::class.java)
            startActivity(intent)
        }
    }
}