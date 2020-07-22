package com.gulshansutey.secondapplication

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val INT_EXTRA_A = "extra_a"
        const val INT_EXTRA_B = "extra_b"
        const val EXTRA_OPERATION = "extra_operation"
        const val OPERATION_ADD = "Addition"
        const val RESPONSE_DATA = "response_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_done.setOnClickListener {
            if (!intent.hasExtra(EXTRA_OPERATION))return@setOnClickListener
            intent.putExtra(
                RESPONSE_DATA,
                processRequest(
                    intent.getStringExtra(EXTRA_OPERATION)!!,
                    intent.getIntExtra(INT_EXTRA_A, 0),
                    intent.getIntExtra(INT_EXTRA_B, 0)
                )
            )
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }


    private fun processRequest(operation: String, a: Int, b: Int) =
        when (operation) {
            OPERATION_ADD -> "Input one - $a\nInput two - $b\nAction - $operation\nOutput is - ${a + b}"
            else -> "Input one - $a\nInput two - $b\nAction - $operation\nOutput is - ${a - b}"
        }


}