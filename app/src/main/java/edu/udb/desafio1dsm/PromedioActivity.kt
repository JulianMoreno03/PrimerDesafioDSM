package edu.udb.desafio1dsm

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class PromedioActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_promedio)

        //obtenemos todos nuestros datos
        val nombre : EditText = findViewById(R.id.Nombre);
        val resultado :TextView = findViewById(R.id.resultado);
        resultado.text = ""
        //notas
        val primeraNota : EditText = findViewById(R.id.PrimeraNota);
        val segundaNota : EditText = findViewById(R.id.SegundaNota);
        val terceraNota : EditText = findViewById(R.id.TerceraNota);
        val cuartaNota : EditText = findViewById(R.id.CuartaNota);
        val quintaNota : EditText = findViewById(R.id.QuintaNota);

        //btns
        val btnCalcular : Button = findViewById(R.id.btnCalcular)
        val btnBorrar : Button = findViewById(R.id.btnBorrar)


        btnCalcular.setOnClickListener{

            //convertimos todos los datos para poder trabajar y verificar que no sean nulos
            val name = nombre.text.toString();
            val nota1 = primeraNota.text.toString().toFloatOrNull();
            val nota2 = segundaNota.text.toString().toFloatOrNull();
            val nota3 = terceraNota.text.toString().toFloatOrNull();
            val nota4 = cuartaNota.text.toString().toFloatOrNull();
            val nota5 = quintaNota.text.toString().toFloatOrNull();

            //creamos una función para validar cada nota sin necesidad de repetir codigo
            fun validarNota(nota: Float?, nombreNota: String): Boolean {
                if (nota == null) {
                    Toast.makeText(this, "$nombreNota no es válida", Toast.LENGTH_SHORT).show()
                    return false
                }

                if (nota < 0 || nota > 10) {
                    Toast.makeText(this, "$nombreNota debe estar entre 0 y 10", Toast.LENGTH_SHORT).show()
                    return false
                }

                return true
            }

            // Llamamos a la función para cada nota
            val notasValidas = validarNota(nota1, "Nota 1") &&
                    validarNota(nota2, "Nota 2") &&
                    validarNota(nota3, "Nota 3") &&
                    validarNota(nota4, "Nota 4") &&
                    validarNota(nota5, "Nota 5")

            if (notasValidas) {
                val promedio = (nota1!! * 0.15) + (nota2!! * 0.15)  + (nota3!! * 0.20)  +
                        (nota4!! * 0.25)  + (nota5!! * 0.25)

                val resulado = if(promedio >= 6) "Aprobado" else "Reprobado"

                // Muestra el promedio y el resultado en el TextView
                resultado.text = "El alumno :$name\n " +
                        "tiene un promedio de :$promedio\n " +
                        "por lo cual esta $resulado"
            }


        }

        btnBorrar.setOnClickListener{
            nombre.text.clear()
            primeraNota.text.clear()
            segundaNota.text.clear()
            terceraNota.text.clear()
            cuartaNota.text.clear()
            quintaNota.text.clear()

            resultado.text = "";
        }




        //capturamos el btn para volver
        val btnVolver : Button = findViewById(R.id.btnVolver);

        //asignamos funcion
        btnVolver.setOnClickListener{
            irAMenu();
        }

    }
    //funcion para regresar al menu
    fun irAMenu(){
        val intent = Intent(this, MainActivity::class.java).apply {  }
        startActivity(intent)
    }


}