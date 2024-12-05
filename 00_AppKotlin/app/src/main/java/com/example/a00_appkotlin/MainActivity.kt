package com.example.a00_appkotlin

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

//Para extender de las clases en Kotlin se ponen dos puntos ":"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var user = Usuario()
        user.nombre = "Felix" //Realmente esta invocando al set
        Log.d("MainActivity", "Nombre: " + user.nombre)//Invocando el get

        val boton1 = findViewById<Button>(R.id.boton1)
        val boton2 : Button = findViewById(R.id.boton2)

        boton1.setOnClickListener({
            Log.d("MainActivity", "Has pulsado el boton 1")
        })

        boton2.setOnClickListener{v ->
            Log.d("MainActivity", "Pulsado boton 2" + v.toString())
            Log.d("MainActivity", "Esto es otra linea")
        }

    }
}