package com.example.myapplication

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.Calendar
import kotlin.math.roundToLong

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var button: Button = findViewById(R.id.choose)
        button.setOnClickListener{
            chooseDate()
        }
    }
    fun chooseDate(){
        var dp = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, month, date ->
            var minute:TextView= findViewById(R.id.minute)
            var current = Calendar.getInstance()
            var formerly = Calendar.getInstance()
            formerly.set(year, month, date)
            var x:Long = ((current.timeInMillis - formerly.timeInMillis)/60000.0).roundToLong()
            minute.text = "$x"
        }, 2023, 10, 30)
        dp.show()
    }
}