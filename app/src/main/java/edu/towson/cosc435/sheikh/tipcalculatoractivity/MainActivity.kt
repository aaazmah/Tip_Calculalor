package edu.towson.cosc435.sheikh.tipcalculatoractivity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitymain)

        val button = findViewById<Button>(R.id.calculate_btn)
        button?.setOnClickListener { calculateTip() }


    }



    private fun calculateTip(){

        try {
            val amount_number = findViewById<EditText>(R.id.amount_number) // finds the amount entered text view by id into a varaiable
            val inputString: String = amount_number.editableText.toString() // converts that into string
            val radio_group = findViewById<RadioGroup>(R.id.radiogroup) // find the radio group
            val selectedId = radio_group.checkedRadioButtonId // can select certain radio buttons now


            val convert_type: ConvertType = when (selectedId) {
                R.id.radioButton3 -> ConvertType.ten
                R.id.radioButton2 -> ConvertType.twenty
                R.id.radioButton -> ConvertType.thirty
                else -> throw Exception("Not Expected")

            }

            val inputDouble: Double = inputString.toDouble()

            val result: Double = calculate(inputDouble, convert_type)


            val formatText = resources.getString(R.string.Result)

            val calculatedResult = findViewById<TextView>(R.id.calculatedresult)
            calculatedResult.text = result.toString()
            calculatedResult.text = String.format(formatText, result)

        } catch (e: Exception){
            if (e.message!= null){
                Log.e(MainActivity::class.java.simpleName, e.message!!)
            }
            Toast.makeText(this, "Please input number", Toast.LENGTH_LONG).show();
        }

    }



}