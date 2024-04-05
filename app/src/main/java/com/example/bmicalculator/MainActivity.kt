package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val weightText = findViewById<EditText>(R.id.etWeight)
        val heightText = findViewById<EditText>(R.id.etHeight)
        val calcButton = findViewById<Button>(R.id.btnCalculate)

        calcButton.setOnClickListener {
            val weight = weightText.text.toString()
            val height = heightText.text.toString()
            if (validInput(weight, height)) {
                val calculation = (weight.toDouble() / height.toDouble() / height.toDouble()) * 10000
                val bmifinal = String.format("%.2f", calculation).toDouble()
                displayResult(bmifinal)
            }
        }
    }

    private fun validInput(weight: String?, height: String?): Boolean {
        if (weight.isNullOrEmpty() || height.isNullOrEmpty()) {
            Toast.makeText(this, "Please Enter Details", Toast.LENGTH_SHORT).show()
            return false
        } else {
            return true
        }
    }

    private fun displayResult(bmi: Double) {
        val index = findViewById<TextView>(R.id.tvIndex)
        val result = findViewById<TextView>(R.id.tvResult)
        val info = findViewById<TextView>(R.id.tvInfo)
        index.text = bmi.toString()
        var messageWeight = ""
        var messageInfo = ""
        var color = 0
        when {
            bmi >= 30.00 -> {
                messageWeight = "Obese"
                messageInfo = "(Obese range is 30.0 above)"
                color = R.color.obese
            }

            bmi in 25.00..29.99 -> {
                messageWeight = "Overweight"
                messageInfo = "(Overweight range is 25.0 - 29.9)"
                color = R.color.over_weight
            }

            bmi in 18.50..24.99 -> {
                messageWeight = "Healthy"
                messageInfo = "(Normal range is 18.5 - 24.9)"
                color = R.color.normal
            }

            bmi <= 18.49 -> {
                messageWeight = "Underweight"
                messageInfo = "(Underweight range is 18.4 below)"
                color = R.color.under_weight
            }
        }
        result.setTextColor(ContextCompat.getColor(this, color))
        result.text = messageWeight
        info.text = messageInfo
    }
}

//My code

//val weightText = findViewById<EditText>(R.id.etWeight)
//val heightText = findViewById<EditText>(R.id.etHeight)
//val calculate = findViewById<Button>(R.id.btnCalculate)
//val weight = weightText.text.toString()
//val height = heightText.text.toString()
//if(validInput(weight,height)) {
//    val calculation = (weight.toDouble() / height.toDouble() / height.toDouble()) * 10000
//    var bmifinal = String.format("%.2f", calculation).toFloat()
//}
//calculate.setOnClickListener {
//    val bmifinal2 = bmifinal
//    val index = findViewById<TextView>(R.id.tvIndex)
//    val result = findViewById<TextView>(R.id.tvResult)
//    val info = findViewById<TextView>(R.id.tvInfo)
//    var message = ""
//    var messageWeight = ""
//    var messageInfo = ""
//    var color = 0
//    if (calculation <= 0) {
//        Toast.makeText(this, "Please complete the details", Toast.LENGTH_SHORT).show()
//    } else if (calculation >= 30) {
//        color = R.color.obese
//        message = "$bmifinal2"
//        messageWeight = "Obese"
//        messageInfo = "(Obese range is 30.0 above)"
//    } else if (calculation >= 25) {
//        color = R.color.over_weight
//        message = "$bmifinal2"
//        messageWeight = "Overweight"
//        messageInfo = "(Overweight range is 25.0 - 29.9)"
//    } else if (calculation >= 18.5) {
//        color = R.color.normal
//        message = "$bmifinal2"
//        messageWeight = "Healthy"
//        messageInfo = "(Normal range is 18.5 - 24.9)"
//    } else {
//        color = R.color.under_weight
//        message = "$bmifinal2"
//        messageWeight = "Underweight"
//        messageInfo = "(Underweight range is 18.4 below)"
//    }
//    result.setTextColor(ContextCompat.getColor(this, color))
//    index.text = message
//    result.text = messageWeight
//    info.text = messageInfo
//}
//}
//
//private fun validInput(weight: String?, height: String?): Boolean {
//    when {
//        weight.isNullOrEmpty() || height.isNullOrEmpty() -> {
//            return false
//        }
//        else -> {
//            return true
//        }
//    }
//}