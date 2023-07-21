package com.example.conversordemonedasm5i17

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.conversordemonedasm5i17.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val divisas = listOf<String>("Dolar", "Pesos", "Euro")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.spinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, divisas)
        binding.spinner2.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, divisas)
    }
}