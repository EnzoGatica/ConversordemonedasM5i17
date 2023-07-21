package com.example.conversordemonedasm5i17

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.example.conversordemonedasm5i17.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val divisas = listOf<String>("USD", "CLP", "EUR")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.spinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, divisas)
        binding.spinner2.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, divisas)

        initListener()
    }

    private fun initListener() {
        binding.btnConvert.setOnClickListener {
            val monto = binding.editTextEntrada.text.toString().toDouble()
            val divisaActual = binding.spinner.selectedItem.toString()
            val divisaCambio = binding.spinner2.selectedItem.toString()
            Log.d("Estamos en el initListener", "$monto $divisaActual $divisaCambio")
            val resultado = conversorDivisas(monto, divisaActual, divisaCambio)
            binding.txtRersultado.text = resultado.toString()
            limpiar()
        }
    }
    fun conversorDivisas(monto : Double, divisaActual : String, divisaCambio: String): Double{

        var resultado = monto
        when (divisaActual) {
            "USD" -> if(divisaCambio == "CLP"){resultado = monto * 817}else if (divisaCambio == "USD"){resultado = monto * 1 } else if (divisaCambio == "EUR"){resultado = monto * 0.89}
            "CLP"-> if(divisaCambio == "CLP"){resultado = monto * 1}else if (divisaCambio == "USD"){resultado =monto * 0.001} else if (divisaCambio == "EUR"){resultado =monto * 0.001}
            "EUR" -> if(divisaCambio == "CLP"){resultado = monto * 910  }else if (divisaCambio == "USD"){ resultado =monto * 1.11 } else if (divisaCambio == "EUR"){resultado =monto * 1}
            else ->{resultado = monto}
        }

        return resultado
    }
    fun limpiar(){
        binding.btnReset.setOnClickListener {
            binding.txtRersultado.text = ""
            binding.editTextEntrada.setText("")
        }
    }
}