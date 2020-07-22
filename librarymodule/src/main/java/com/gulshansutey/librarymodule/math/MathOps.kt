package com.gulshansutey.librarymodule.math

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.gulshansutey.librarymodule.OperationActivity


class MathOps(private val context: AppCompatActivity) : MathOpsInterface {

    companion object {
        const val REQUEST_CODE = 20
        const val RESPONSE_DATA = "response_data"
    }

    override fun onSubtraction(a: Int, b: Int) {
        val intent: Intent? = Intent("com.gulshansutey.secondapplication.action")
        if (intent != null) {
            intent.putExtra(OperationActivity.INT_EXTRA_A, a)
            intent.putExtra(OperationActivity.INT_EXTRA_B, b)
            intent.putExtra(OperationActivity.EXTRA_OPERATION, OperationActivity.OPERATION_SUBTRACT)
            context.startActivityForResult(intent, REQUEST_CODE)
        }
    }

    override fun onAddition(a: Int, b: Int) {
        val intent = Intent(context, OperationActivity::class.java)
        intent.putExtra(OperationActivity.INT_EXTRA_A, a)
        intent.putExtra(OperationActivity.INT_EXTRA_B, b)
        intent.putExtra(OperationActivity.EXTRA_OPERATION, OperationActivity.OPERATION_ADD)
        context.startActivityForResult(intent, REQUEST_CODE)
    }

    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?): String {
        return if (requestCode == REQUEST_CODE) {
            return if (resultCode == Activity.RESULT_OK) {
                data?.extras?.getString(RESPONSE_DATA)!!
            } else {
                "Request Canceled"
            }
        } else ""
    }
}