package com.kwang0.customtoast.helper

import android.content.Context
import android.view.View
import android.widget.Toast
import com.kwang0.customtoast.R
import com.kwang0.customtoast.utils.ResourceUtils

object SystemToastHelper {
    fun showShortToast(context: Context, message: String?) {
        message?.also {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }
    }

    fun showLongToast(context: Context, message: String?) {
        message?.also {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }
    }

    fun showToast(view: View, message: String?) {
        when (view.tag) {
            ResourceUtils.getString(view.context, R.string.tag_short_toast) -> {
                showShortToast(view.context, message)
            }

            ResourceUtils.getString(view.context, R.string.tag_long_toast) -> {
                showLongToast(view.context, message)
            }
        }
    }
}