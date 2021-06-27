package com.example.agrupacionmarilyn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setup()

    }

    private fun setup() {
        title = "Autenticacion"
        buttonRegistrarse.setOnClickListener {
            if (editTextUsuario.text.isNotEmpty() && editTextPassword.text.isNotEmpty()) {
                FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(
                        editTextUsuario.text.toString(), editTextPassword.text.toString()
                    ).addOnCompleteListener {

                        if (it.isSuccessful) {
                            showLocation(it.result?.user?.email ?: "" )
                        } else {
                            showAlert()
                        }
                    }
            }
        }
        buttonIniciarSesion.setOnClickListener {
            if (editTextUsuario.text.isNotEmpty() && editTextPassword.text.isNotEmpty())
                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(
                        editTextUsuario.text.toString(),editTextPassword.text.toString()
                    ).addOnCompleteListener {
                        if (it.isSuccessful) {
                            showLocation(it.result?.user?.email ?: "")
                        } else {
                            showAlert()
                        }
                    }
        }
    }

    private fun showAlert() {

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error autenticando el usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showLocation(email: String ) {
        val intent = Intent(this, LocationActivity::class.java).apply {
            putExtra("username", email)
            putExtra("email", email)
        }
        startActivity(intent)
    }
}