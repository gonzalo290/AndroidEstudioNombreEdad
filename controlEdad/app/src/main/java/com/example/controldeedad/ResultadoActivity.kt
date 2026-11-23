package com.example.controldeedad

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultadoActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NOMBRE = "extra_nombre"
        const val EXTRA_EDAD = "extra_edad"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val txtBienvenida = findViewById<TextView>(R.id.txtBienvenida)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)
        val btnVolver = findViewById<Button>(R.id.btnVolver)

        val nombre = intent.getStringExtra(EXTRA_NOMBRE) ?: ""
        val edad = intent.getIntExtra(EXTRA_EDAD, 0)

        txtBienvenida.text = "Bienvenido/a $nombre"

        txtResultado.text = when {
            edad < 18 -> "Eres menor de edad"
            edad == 18 -> "Acabas de cumplir 18 años"
            else -> "Eres mayor de edad"
        }

        btnVolver.setOnClickListener {
            finish()
        }
    }
}