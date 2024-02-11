package com.example.assignment01

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var edit1: EditText? = null
    private var edit2: EditText? = null
    private var edit3: EditText? = null
    private var edit4: EditText? = null
    private var edit5: EditText? = null
    private var edit6: EditText? = null
    private var edit7: EditText? = null
    private var btn1: Button? = null
    private var btn2: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edit1 = findViewById(R.id.studentName)
        edit2 = findViewById(R.id.marks1)
        edit3 = findViewById(R.id.marks2)
        edit4 = findViewById(R.id.marks3)
        edit5 = findViewById(R.id.total)
        edit6 = findViewById(R.id.average)
        edit7 = findViewById(R.id.grade)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn1?.setOnClickListener { calculateMarks() }
        btn2?.setOnClickListener { clearFields() }
    }

    private fun calculateMarks() {
        val name = edit1?.text.toString()
        val m1: Int = edit2?.text.toString().toIntOrNull() ?: 0
        val m2: Int = edit3?.text.toString().toIntOrNull() ?: 0
        val m3: Int = edit4?.text.toString().toIntOrNull() ?: 0
        val total: Int = m1 + m2 + m3
        val average: Double = total.toDouble() / 3
        val formattedAverage = String.format("%.2f", average)
        var grade: String = when {
            average > 75 -> "A"
            average > 65 -> "B"
            average > 55 -> "C"
            average > 40 -> "S"
            else -> "F"
        }

        edit5?.setText(total.toString())
        edit6?.setText(formattedAverage)

        edit7?.apply {
            setText(grade)
            textSize = 40f
            paint.isFakeBoldText = true
        }

        // Change the background color of the EditText field based on the grade
        when (grade) {
            "A" -> edit7?.setTextColor(Color.GREEN)
            "B" -> edit7?.setTextColor(Color.YELLOW)
            "C" -> edit7?.setTextColor(Color.BLUE)
            "S" -> edit7?.setTextColor(Color.MAGENTA)
            else -> edit7?.setTextColor(Color.RED)
        }
    }

    private fun clearFields() {
        edit1?.setText("")
        edit2?.setText("")
        edit3?.setText("")
        edit4?.setText("")
        edit5?.setText("")
        edit6?.setText("")
        edit7?.setText("")
        edit1?.requestFocus()
    }
}
