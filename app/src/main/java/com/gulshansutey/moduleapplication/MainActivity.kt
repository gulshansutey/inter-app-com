package com.gulshansutey.moduleapplication

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.gulshansutey.librarymodule.math.MathOps
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var mathOps: MathOps
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mathOps = MathOps(this)
        btn_addition.setOnClickListener {
            if (validateEditText()) mathOps.onAddition(
                et_input_one.textInt(),
                et_input_two.textInt()
            )
        }
        btn_subtraction.setOnClickListener {
            if (validateEditText()) mathOps.onSubtraction(
                et_input_one.textInt(),
                et_input_two.textInt()
            )
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        tv_result.text = mathOps.onActivityResult(requestCode, resultCode, data)
    }


    private fun validateEditText() = when {
        TextUtils.isEmpty(et_input_one.text) -> {
            et_input_one.error = "Enter value"
            false
        }
        TextUtils.isEmpty(et_input_two.text) -> {
            et_input_two.error = "Enter Value"
            false
        }
        else -> true
    }


    private fun EditText.textInt() = this.text.toString().toInt()

}