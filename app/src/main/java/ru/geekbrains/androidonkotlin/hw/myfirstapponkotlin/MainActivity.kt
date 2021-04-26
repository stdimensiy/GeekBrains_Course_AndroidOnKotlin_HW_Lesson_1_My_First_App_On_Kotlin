package ru.geekbrains.androidonkotlin.hw.myfirstapponkotlin

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.geekbrains.androidonkotlin.hw.myfirstapponkotlin.R.string.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // навешиваем кликлиссенер на первую кнопку
        val button = findViewById<Button>(R.id.buttonOne);
        val textView = findViewById<TextView>(R.id.resultClick);
        button.setOnClickListener {
            textView.text = resources.getString(result_message_button_press)
        }
        // задание 5.1 создание простого data class и вывод его полей на экран
        val sdc = SimpleDataClass("Простое наименование", "Простое содержание объекта")
        val resultActionCreateSimpleClass = findViewById<TextView>(R.id.resultActionCreateSimpleClass);
        val dataClassName = findViewById<TextView>(R.id.dataClassName);
        val dataClassContent = findViewById<TextView>(R.id.dataClassContent);
        when(sdc){
            is SimpleDataClass -> {
                resultActionCreateSimpleClass.text = resources.getString(result_message_SimpleData_class_created)
                dataClassName.text = resources.getString(simpleData_field_name_prefix) + sdc.title
                dataClassContent.text =resources.getString(simpleData_field_content_prefix) + sdc.content
            }
            else -> resultActionCreateSimpleClass.text = resources.getString(result_message_is_not_SimpleData_class)
        }
    }
}