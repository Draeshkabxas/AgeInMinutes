package com.drarlibya.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.drarlibya.ageinminutes.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnDatePicker.setOnClickListener {view ->
            clickDatePicker(view)
         }

    }

    private fun clickDatePicker(view:View){
        val myCalender=Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val dayOfMonth = myCalender.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener{
                    view, selectedYear, selectedMonth, selectedDayOfMonth ->
                Toast.makeText(this,
                    "The chosen year is $selectedYear " +
                            ", the month is  $selectedMonth" +
                            ", the day is $selectedDayOfMonth"
                    ,Toast.LENGTH_SHORT).show()

                showSelectedDateText(selectedDayOfMonth,
                    selectedMonth,
                    selectedYear)



            }, year,
            month,
            dayOfMonth).show()
    }


    /*
    This method takes the selected day , month and year
    to show them in SelectedDate text view
     */
    private fun showSelectedDateText(selectedDay: Int, selectedMonth: Int, selectedYear: Int) {
        val selectedDate ="$selectedDay/${selectedMonth+1}/$selectedYear"
        binding.tvSelectedDate.text = selectedDate
    }
}