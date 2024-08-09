package edu.udb.desafio1dsm

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class PromedioActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_promedio)


        val btnVolver : Button = findViewById(R.id.btnVolver);

        btnVolver.setOnClickListener{
            irAMenu();
        }

    }
    fun irAMenu(){
        val intent = Intent(this, MainActivity::class.java).apply {  }
        startActivity(intent)
    }


}