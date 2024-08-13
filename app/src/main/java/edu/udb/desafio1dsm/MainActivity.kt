package edu.udb.desafio1dsm

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //Caputamos todos los btn de nuestro layout
        val btnCalculadora : Button = findViewById(R.id.btnCalculadora);
        val btnPromedio : Button = findViewById(R.id.BtnPromedios);
        val btnDescuento : Button = findViewById(R.id.btnDescuento);



        //Funcion para ir al primer ejercicio
        btnPromedio.setOnClickListener{
            irAPromedio();
        }

        //Funcion para ir al 2 ejercicio
        btnDescuento.setOnClickListener{
            irADescuento();
        }

        //Funcion para ir al 3 ejercicio
        btnCalculadora.setOnClickListener{
            irACalculadora();
        }

    }

    //Creamos funcion para movernos a layout Calculadora
    fun irACalculadora(){
    val intent = Intent(this, CalculadoraActivity::class.java).apply {  }
        startActivity(intent)
    }

    //Creamos funcion para movernos a layout promedio
    fun irAPromedio(){
        val intent = Intent(this, PromedioActivity::class.java).apply {  }
        startActivity(intent)
    }

    //Creamos funcion para movernos a layout descuentos
    fun irADescuento(){
        val intent = Intent(this, DescuentoActivity::class.java).apply {  }
        startActivity(intent)
    }

}