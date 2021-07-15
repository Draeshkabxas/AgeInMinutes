package com.drarlibya.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.drarlibya.ageinminutes.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnDatePicker.setOnClickListener {view ->
            clickDatePicker(view)
         }

    }

    fun clickDatePicker(view:View){
        val myCalender=Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val dayOfMonth = myCalender.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener{
                    view, year, month, dayOfMonth ->
                Toast.makeText(this,"Date Picker works",Toast.LENGTH_SHORT).show()

            }, year,
            month,
            dayOfMonth).show()
    }
}