package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityDadosBinding
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.random.Random

class Dados : AppCompatActivity() {
    private lateinit var binding: ActivityDadosBinding
    private var sum: Int = 0
    private lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDadosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btVolver2.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        handler = Handler(Looper.getMainLooper())
        initEvent()
    }

    private fun initEvent() {
        binding.txtResultado.visibility = View.INVISIBLE
        binding.imageButton.setOnClickListener {
            binding.txtResultado.visibility = View.VISIBLE
            game()
        }
    }

    private fun game() {
        scheduleRun()
    }

    private fun scheduleRun() {
        val schedulerExecutor = Executors.newSingleThreadScheduledExecutor()
        val msc = 1000

        schedulerExecutor.schedule(
            {
                throwDadoInTime()
            },
            msc.toLong(),
            TimeUnit.MILLISECONDS
        )

        schedulerExecutor.shutdown()
    }

    private fun throwDadoInTime() {
        val numDado = Random.nextInt(1, 6)
        val imageView = binding.imagviewDado1

        sum = numDado
        selectView(imageView, numDado)
        viewResult()
    }

    private fun selectView(imgV: ImageView, v: Int) {
        when (v) {
            1 -> imgV.setImageResource(R.drawable.fotogot1)
            2 -> imgV.setImageResource(R.drawable.fotogot2)
            3 -> imgV.setImageResource(R.drawable.fotogot3)
            4 -> imgV.setImageResource(R.drawable.fotogot4)
            5 -> imgV.setImageResource(R.drawable.fotogot5)
        }
    }

    private fun viewResult() {
        handler.post {
            binding.txtResultado.text = sum.toString()
        }
    }
}
