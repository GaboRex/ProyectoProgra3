package com.example.agrupacionmarilyn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginActivity : AppCompatActivity() {
    var buttonIniciarSesion: Button? = null
    var buttonRegistrarse: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        buttonIniciarSesion = findViewById(R.id.buttonIniciarSesion)
        buttonRegistrarse = findViewById(R.id.buttonRegistrarse)

        buttonIniciarSesion?.setOnClickListener {
            val intent = Intent(this, LocationActivity::class.java)
            startActivity(intent)
        }

        buttonRegistrarse?.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}