package edu.udb.desafio1dsm

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class DescuentoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_descuento)

        //instanciamos los descuentos de afp e isss
        val afp = 0.0725;
        val isss = 0.03;

        //Descuento de renta segun salario
        //10%
        val rentaTramo2 = 0.10;
        //20%
        val rentaTramo3 = 0.20;
        //30%
        val rentaTramo4 = 0.30;


        val salario : EditText = findViewById(R.id.salario);
        val nombre : EditText = findViewById(R.id.nombre);
        val calcularButton: Button = findViewById(R.id.btnCalcular)
        val borrarButton :Button = findViewById(R.id.btnBorrar);
        val resultados : TextView = findViewById(R.id.resultados);

        calcularButton.setOnClickListener {
            //validamos que no sea nulo
            var salarioBase = salario.text.toString().toDoubleOrNull();

         if(salarioBase != null ){
             //Calculamos los descuentos
            val descuentoAfp = salarioBase * afp;
            val descuentoIsss = salarioBase * isss;
            var descuentoRenta = 0.0;
            var porcentajeRenta = "";
             var descuentoSalario = salarioBase - descuentoAfp - descuentoIsss;
             //Si el salario es mayor a 2038 se le aplica un 30 porciento
                if (descuentoSalario >= 2038.11 ){
                    descuentoRenta = (descuentoSalario * rentaTramo4)
                    porcentajeRenta = "30%"
                }
                //Si el salario es mayor a 895 y menor a 2038 se le aplica un 20 porciento
               else if (descuentoSalario > 895.25 && descuentoSalario <= 2038.10){
                    descuentoRenta = (descuentoSalario * rentaTramo3)
                    porcentajeRenta = "20%"
                }
                //Si el salario es mayor a 472 y menor a 895 se le aplica un 10 porciento
               else if (descuentoSalario > 472.01 && descuentoSalario < 895.24){
                 descuentoRenta = (descuentoSalario * rentaTramo2)
                    porcentajeRenta = "10%"
                }
                else {
                    descuentoRenta = 0.0
                    porcentajeRenta = "0%"
                }
             // Calculamos el salario neto
             val salarioNeto = salarioBase - descuentoRenta -descuentoAfp -descuentoIsss;

             Log.d("DescuentoActivity", "Salario Base: $salarioBase")
             Log.d("DescuentoActivity", "Descuento AFP: $descuentoAfp")
             Log.d("DescuentoActivity", "Descuento ISSS: $descuentoIsss")
             Log.d("DescuentoActivity", "Descuento Renta: $descuentoRenta")

             // Mostramos los resultados
             resultados.text = """
            Nombre: ${nombre.text}
            Salario Base: $salarioBase
            Descuento AFP 7.25%: $descuentoAfp
            Descuento ISSS 3%: $descuentoIsss
            Descuento Renta: $porcentajeRenta : $descuentoRenta
            Salario Neto: $salarioNeto
        """.trimIndent()
         } else {
             // Si el salario no es válido, mostramos un mensaje de error
             resultados.text = "Por favor, ingresa un salario válido."
         }
        }
        // Configuramos el botón de borrar
        borrarButton.setOnClickListener {
            // Limpiamos los campos de entrada y los resultados
            salario.text.clear()
            nombre.text.clear()
            resultados.text = ""
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