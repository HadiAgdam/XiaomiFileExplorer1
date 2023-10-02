package com.hadiagdamapps.xiaomifileexplorer1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.hadiagdamapps.xiaomifileexplorer1.activity.intro.IntroActivity
import com.hadiagdamapps.xiaomifileexplorer1.tools.Activity

class MainActivity : Activity(R.layout.activity_main) {
    override fun initViews() {}

    override fun main() {

        // temp
        startActivity(Intent(this@MainActivity, IntroActivity::class.java))

    }
}