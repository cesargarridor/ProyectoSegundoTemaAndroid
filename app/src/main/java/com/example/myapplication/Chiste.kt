package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.speech.tts.TextToSpeech
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityChisteBinding
import java.util.*

class Chiste : AppCompatActivity() {

    lateinit var binding: ActivityChisteBinding
    private lateinit var textToSpeech: TextToSpeech
    private lateinit var progressBar: ProgressBar
    private val handler = Handler(Looper.getMainLooper())
    private var progressBarShown = false

    private val chistes = arrayOf(
        "Oiga, ¿el otorrino va por número?\n\nVan nombrando.",
        "¿Por qué las mujeres de Lepe beben agua del mar? Para ser más saladas.",
        "¿Qué le dice un jardinero a otro? Nos vemos cuando podamos.",
        "La mayor exportación de Australia son los boomerangs. También son la mayor importación.",
        "¿Y cómo se llama un boomerang que no vuelve? Palo.",
        "Intenté organizar un torneo profesional de escondite, pero fue un completo fracaso. Los buenos jugadores son difíciles de encontrar.",
        "El otro día vendí mi aspiradora. Lo único que hacía era acumular polvo.",
        "¿Qué es rojo y tiene forma de cubo? Un cubo azul pintado de rojo.",
        "Van dos ciegos y le dice uno al otro:\n\n— Ojalá lloviera.\n\n— Ojalá yo también.",
        "— Mira, tronco, una piedra preciosa.\n\n— Pero si es un ladrillo...\n\n— Pues a mí me gusta."
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChisteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btVolver.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        progressBar = binding.progressBar
        val button = binding.btnExample

        textToSpeech = TextToSpeech(this) { status ->
            if (status == TextToSpeech.SUCCESS) {
                val locale = Locale("es", "ES")
                textToSpeech.language = locale
            }
        }

        handler.postDelayed({
            if (!progressBarShown) {
                progressBar.visibility = ProgressBar.VISIBLE
                progressBarShown = true
                handler.postDelayed({
                    progressBar.visibility = ProgressBar.INVISIBLE
                }, 499)
            }
        }, 500)

        button.setOnClickListener {
            val chisteSeleccionado = chistes.random()

            textToSpeech.speak(chisteSeleccionado, TextToSpeech.QUEUE_FLUSH, null, null)
        }
    }

    override fun onDestroy() {
        textToSpeech.stop()
        textToSpeech.shutdown()
        super.onDestroy()
    }
}
