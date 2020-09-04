package com.kwang0.customtoast

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.kwang0.customtoast.helper.SystemToastHelper
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonSystemShortToast.setOnClickListener(this)
        buttonSystemLongToast.setOnClickListener(this)
        buttonCustomToast.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        v?.also {
            when (v) {
                buttonSystemShortToast -> {
                    SystemToastHelper.showShortToast(this, "Show Short Toast")
                }

                buttonSystemLongToast -> {
                    SystemToastHelper.showLongToast(this, "Show Long Toast")
                }

                // You can use tags for divide usage for showing toast
                // If you want to check this out, please remove upside code
                buttonSystemShortToast, buttonSystemLongToast -> {
                    SystemToastHelper.showToast(v, "Show Toast")
                }

                buttonCustomToast -> {
                    customToast.showCustomToast()
                }
            }
        }
    }


}