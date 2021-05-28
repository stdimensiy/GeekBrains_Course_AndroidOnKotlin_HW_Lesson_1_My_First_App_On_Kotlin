package ru.geekbrains.androidonkotlin.hw.myfirstapponkotlin

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.geekbrains.androidonkotlin.hw.myfirstapponkotlin.R.string.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.buttonOne)
        val textView = findViewById<TextView>(R.id.resultClick)
        button.setOnClickListener {
            textView.text = resources.getString(result_message_button_press)
            loopFirstAndSecond(10)
        }
        // задание 5.1 создание простого data class и вывод его полей на экран
        val sdc = SimpleDataClass(resources.getString(simpleData_field_title_default_text),
                resources.getString(simpleData_field_content_default_text))
        val resultActionCreateSimpleClass = findViewById<TextView>(R.id.resultActionCreateSimpleClass)
        val dataClassTitle = findViewById<TextView>(R.id.dataClassTitle)
        val dataClassContent = findViewById<TextView>(R.id.dataClassContent)
        when (sdc) {
            is SimpleDataClass -> {
                resultActionCreateSimpleClass.text = resources.getString(result_message_SimpleData_class_created)
                dataClassTitle.text = resources.getString(simpleData_field_title_prefix) + sdc.title
                dataClassContent.text = resources.getString(simpleData_field_content_prefix) + sdc.content
            }
            else -> resultActionCreateSimpleClass.text = resources.getString(result_message_is_not_SimpleData_class)
        }
        val copyResultActionCreateSimpleClass = findViewById<TextView>(R.id.copyresultActionCreateSimpleClass)
        val copyDataClassTitle = findViewById<TextView>(R.id.copydataClassTitle)
        val copyDataClassContent = findViewById<TextView>(R.id.copydataClassContent)
        val copySdc = sdc.copy(resources.getString(simpleData_field_default_prefix_copy_text) + sdc.title)
        copySdc.content = resources.getString(simpleData_field_content_test_new_content)
        when (copySdc) {
            is SimpleDataClass -> {
                copyResultActionCreateSimpleClass.text = resources.getString(result_message_SimpleData_class_copied)
                copyDataClassTitle.text = resources.getString(simpleData_field_title_prefix) + copySdc.title
                copyDataClassContent.text = resources.getString(simpleData_field_content_prefix) + copySdc.content
            }
            else -> resultActionCreateSimpleClass.text = resources.getString(result_message_is_not_SimpleData_class)
        }
        // циклы
        // циклы whiLe и do...whiLe практически идентичны java поэтому решено обкатать for
        // на "первый, второй, Расчитась!!!
        // задача. в цикле (нужно выводить "первы" или "второй" в зависимости от итерации расчета в конце вывести"Расчет окончен!"
        // старт процесса прикрутить к нажатию кнопки
    }


    fun loopFirstAndSecond(maxInt: Int) {
        Thread {
            val loopActionStatus = findViewById<TextView>(R.id.loopActionStatus)
            loopActionStatus.text = resources.getString(loop_started)
            val loopResult = findViewById<TextView>(R.id.loopResult)
            for (i in 1..maxInt) {
                Log.d("Thread", "Итерация: " + i + "поток: " + Thread.currentThread())
                when {
                    i % 2 == 0 -> {
                        this.runOnUiThread(java.lang.Runnable {
                            loopResult.textAlignment = View.TEXT_ALIGNMENT_TEXT_END
                            loopResult.text = resources.getString(loop_yell_two)
                        })
                    }
                    else -> {
                        this.runOnUiThread(java.lang.Runnable {
                            loopResult.textAlignment = View.TEXT_ALIGNMENT_TEXT_START
                            loopResult.text = resources.getString(loop_yell_one)
                        })
                    }
                }
                Thread.sleep(1000)
            }
            this.runOnUiThread(java.lang.Runnable {
                loopResult.textAlignment = View.TEXT_ALIGNMENT_CENTER
                loopResult.text = resources.getString(loop_yell_calculation_is_over)
                loopActionStatus.text = resources.getString(loop_finished)
            })
        }.start()
    }
}