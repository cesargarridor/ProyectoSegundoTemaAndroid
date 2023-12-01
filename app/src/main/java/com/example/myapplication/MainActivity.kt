package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btChiste.setOnClickListener {
            val intent = Intent(this, Chiste::class.java)
            startActivity(intent)
        }
        binding.btDados.setOnClickListener{
            val intent = Intent(this,Dados::class.java)
            startActivity(intent)
        }
        binding.btentrada.setOnClickListener{
            val intent = Intent(this,Entradata::class.java)
            startActivity(intent)
        }
    }
}