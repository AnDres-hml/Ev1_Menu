package com.example.ev1_menu

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etCantidadPchoclo = findViewById<EditText>(R.id.etCantidadPchoclo)
        val etCantidadCazuela = findViewById<EditText>(R.id.etCantidadCazuela)
        val stcPropina = findViewById<Switch>(R.id.stcPropina)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val tvPlatillos = findViewById<TextView>(R.id.tvPlatillos)
        val tvPropina = findViewById<TextView>(R.id.tvPropina)
        val tvTotal = findViewById<TextView>(R.id.tvTotal)

        btnCalcular.setOnClickListener {
            val cantidad1 = etCantidadPchoclo.text.toString().toIntOrNull() ?: 0
            val cantidad2 = etCantidadCazuela.text.toString().toIntOrNull() ?: 0

            val precio1 = 12000
            val precio2 = 10000
            val totalPlatos = (cantidad1 * precio1) + (cantidad2 * precio2)

            val montoPropina = if (stcPropina.isChecked) {
                totalPlatos * 0.1
            } else {
                0.0
            }

            val totalConPropina = totalPlatos + montoPropina
            tvPlatillos.text = "Subtotal: $$totalPlatos"
            tvPropina.text = "Monto de la propina: $${String.format("%.0f", montoPropina)}"
            tvTotal.text = "Total con propina: $${String.format("%.0f", totalConPropina)}"
        }

    }

}