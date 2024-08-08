package edu.udb.desafio1dsm

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class CalculadoraActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //Cambiamos el layout para ver la vista de Calculadora
        setContentView(R.layout.activity_calculadora)

        val btnVolver : Button = findViewById(R.id.btnVolver);

        //asignamos la funcion segun su respectivo boton
        btnVolver.setOnClickListener{
            irAMenu();
        }
    }

    fun irAMenu() {
        val intent = Intent(this, MainActivity::class.java).apply {  }
        startActivity(intent)
    }

}