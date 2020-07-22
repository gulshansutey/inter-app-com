package com.gulshansutey.librarymodule

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gulshansutey.librarymodule.math.MathOps
import kotlinx.android.synthetic.main.activity_operation.*

class OperationActivity : AppCompatActivity() {

    companion object {
        const val INT_EXTRA_A = "extra_a"
        const val INT_EXTRA_B = "extra_b"
        const val EXTRA_OPERATION = "extra_operation"
        const val OPERATION_SUBTRACT = "Subtraction"
        const val OPERATION_ADD = "Addition"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_operation)
        actionBar?.title = "MathOps"
        btn_done.setOnClickListener {
            intent.putExtra(
                MathOps.RESPONSE_DATA, processRequest(intent.getStringExtra(EXTRA_OPERATION)!!, intent.getIntExtra(INT_EXTRA_A, 0), intent.getIntExtra(INT_EXTRA_B, 0))
            )
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }


    private fun processRequest(operation: String, a: Int, b: Int) =
        when (operation) {
            OPERATION_ADD -> "Input one - $a\nInput two - $b\nAction - $operation\nOutput is - ${a + b}"
            else -> "Input one - $a\nInput two - $b\nAction - $operation\nOutput is - ${a - b}"
        }


}