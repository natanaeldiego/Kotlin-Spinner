package com.example.spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var texto: TextView
    lateinit var botao: Button
    lateinit var menu: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        texto = findViewById(R.id.textView)
        botao = findViewById(R.id.button)
        menu = findViewById(R.id.spinner)

        var estados = arrayOf("Piauí", "Distrito Federal", "São Paulo")
        menu.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, estados)
        menu.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                texto.text = estados[position]
            }
        }

        botao.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                var posicao = menu.selectedItemPosition
                Toast.makeText(applicationContext, estados[posicao], Toast.LENGTH_LONG).show()
            }

        })
    }
}