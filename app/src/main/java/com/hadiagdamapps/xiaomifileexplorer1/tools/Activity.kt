package com.hadiagdamapps.xiaomifileexplorer1.tools

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

abstract class Activity(private val layout: Int) : AppCompatActivity() {

    abstract fun initViews()
    abstract fun main()

    fun log(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)
        initViews()
        main()
    }
}