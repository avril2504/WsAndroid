package com.example.actividad_02_minicalculadora_kotlin

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var n1 : EditText
    private lateinit var n2 : EditText
    private lateinit var resultado : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        n1 = findViewById(R.id.numero1)
        n2 = findViewById(R.id.numero2)
        resultado = findViewById(R.id.resultado)

        val sumar : Button = findViewById(R.id.sumar)
        sumar.setOnClickListener({
            if (estaVacio()){
                val suma : Double = n1.text.toString().toDouble() +
                        n2.text.toString().toDouble()
                resultado.setText(suma.toString())
            }
        })

        val restar : Button = findViewById(R.id.restar)
        restar.setOnClickListener({
            if (estaVacio()){
                val resta : Double = n1.text.toString().toDouble() -
                        n2.text.toString().toDouble()
                resultado.setText(resta.toString())
            }
        })

        val multiplicar : Button = findViewById(R.id.multiplicar)
        multiplicar.setOnClickListener({
            if (estaVacio()){
                val multiplicacion : Double = n1.text.toString().toDouble() *
                        n2.text.toString().toDouble()
                resultado.setText(multiplicacion.toString())
            }
        })

        val dividir : Button = findViewById(R.id.dividir)
        dividir.setOnClickListener({
            if (estaVacio()){
                val division : Double = n1.text.toString().toDouble() /
                        n2.text.toString().toDouble()
                resultado.setText(division.toString())
            }
        })

        val potencia : Button = findViewById(R.id.potencia)
        potencia.setOnClickListener({
            if (estaVacio()){
                val base : Double = n1.text.toString().toDouble()
                val exponente : Double = n2.text.toString().toDouble()
                val resultadoPotencia : Double = Math.pow(base, exponente)
                resultado.setText(resultadoPotencia.toString())
            }
        })

        val borrar : Button = findViewById(R.id.borrar)
        borrar.setOnClickListener({
            n1.setText("")
            n2.setText("")
            resultado.setText("")
        })
    }

    fun estaVacio() : Boolean {
        val numero1 : String = n1.text.toString().trim()
        val numero2 : String = n2.text.toString().trim()

        if (numero1.isEmpty() || numero2.isEmpty()){
            resultado.setText("Falta algún número")
            return false
        }
        return true
    }
}