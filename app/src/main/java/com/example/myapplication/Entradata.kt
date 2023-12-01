package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityEntradataBinding

class Entradata : AppCompatActivity() {
    private lateinit var binding: ActivityEntradataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEntradataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btVolver3.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val tiempoOptions = arrayOf("1 seg", "2 seg", "3 seg")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, tiempoOptions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner.adapter = adapter

        binding.btnFloat.setOnClickListener {
            val nombre = binding.editText.text.toString()
            val apellidos = binding.editAuto.text.toString()
            val isCheckedChk1 = binding.chk1.isChecked
            val isCheckedChk2 = binding.chk2.isChecked
            val isCheckedChk3 = binding.chk3.isChecked
            val radioButtonId = binding.radioGroup.checkedRadioButtonId
            val selectedRadioButton: String = when (radioButtonId) {
                R.id.btr_1 -> "RadioButton 1"
                R.id.btr_2 -> "RadioButton 2"
                R.id.btr_3 -> "RadioButton 3"
                else -> "Ningún RadioButton seleccionado"
            }
            val switchState = binding.switchBtn.isChecked
            val selectedSpinnerItem = binding.spinner.selectedItem.toString()

            mostrarDialogo("Nombre: $nombre\nApellidos: $apellidos\nSpinner: $selectedSpinnerItem\n" +
                    "CheckBox 1: $isCheckedChk1\nCheckBox 2: $isCheckedChk2\nCheckBox 3: $isCheckedChk3\n" +
                    "RadioButton: $selectedRadioButton\nSwitch: $switchState")
        }
    }

    private fun mostrarDialogo(mensaje: String) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(mensaje)
            .setPositiveButton("Aceptar", null)
            .create()
            .show()
    }
}
