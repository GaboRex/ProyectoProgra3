package com.example.agrupacionmarilyn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class ListViewActivity : AppCompatActivity() {
    lateinit var listView: ListView
    val listDeLugares = listOf("Hipermaxi", "Ketal", "Fidalga", "Juan Del Sur", "Andys")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        listView = findViewById(R.id.listViewLugares)
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listDeLugares)

        listView.adapter = adapter

    }
}