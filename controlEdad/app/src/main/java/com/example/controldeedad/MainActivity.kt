
package com.example.controldeedad

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editNombre = findViewById<EditText>(R.id.editNombre)
        val editEdad = findViewById<EditText>(R.id.editEdad)

        val btnComprobar = findViewById<Button>(R.id.btnComprobar)
        val btnLimpiar = findViewById<Button>(R.id.btnLimpiar)

        btnComprobar.setOnClickListener {

            val nombre = editNombre.text.toString()
            val edadTexto = editEdad.text.toString()

            // Comprobamos que el nombre no esté vacío
            if (nombre.isBlank()) {
                Toast.makeText(this, "Escribe tu nombre", Toast.LENGTH_SHORT).show()

                return@setOnClickListener
            }

            // Convertimos la edad a número
            val edad = edadTexto.toIntOrNull()

            // Comprobamos que la edad sea válida
            if (edad == null || edad < 1 || edad > 120) {
                Toast.makeText(this, "Introduce una edad válida", Toast.LENGTH_SHORT).show()

                return@setOnClickListener
            }

            // Creamos el Intent para abrir ResultadoActivity
            val intent = Intent(this, ResultadoActivity::class.java)

            // Enviamos el nombre y la edad
            intent.putExtra(ResultadoActivity.EXTRA_NOMBRE, nombre)
            intent.putExtra(ResultadoActivity.EXTRA_EDAD, edad)

            // Abrimos la segunda pantalla
            startActivity(intent)
        }

        // El botón Limpiar borra solamente los campos
        btnLimpiar.setOnClickListener {
            editNombre.text.clear()
            editEdad.text.clear()
        }
    }
}
