package ru.geekbrains.androidonkotlin.hw.myfirstapponkotlin

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // навешиваем кликлиссенер на первую кнопку
        val button = findViewById<Button>(R.id.buttonOne);
        val textView = findViewById<TextView>(R.id.resultClick);
        button.setOnClickListener {
            textView.text = resources.getString(R.string.result_message_button_press)
        }
    }
}