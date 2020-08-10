package com.kwang0.customtoast

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import android.view.animation.LinearInterpolator
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonToast.setOnClickListener {
//            showSystemToast()
            showCustomToast()
        }
    }

    private fun showSystemToast() {
        Toast.makeText(this, "$count", Toast.LENGTH_SHORT).show()
        addCount()
    }

    private fun showCustomToast() {
        textToast.clearAnimation()
        textToast.text = "$count"

        textToast.visibility = View.VISIBLE
        textToast.animate().apply {
            duration = 500
            alpha(0.8f)
            setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    hideCustomToast()
                }
            })
        }.start()
        addCount()
    }

    private fun hideCustomToast() {
        textToast.animate().apply {
            duration = 500
            startDelay = 500
            alpha(0.0f)
            setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    textToast.visibility = View.GONE
                }
            })
        }.start()
    }

    private fun addCount() {
        count++
    }
}