package com.hadiagdamapps.xiaomifileexplorer1.activity.intro

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.hadiagdamapps.xiaomifileexplorer1.R
import com.hadiagdamapps.xiaomifileexplorer1.tools.Activity
import com.hadiagdamapps.xiaomifileexplorer1.tools.PermissionDeniedDialog

class IntroActivity : Activity(R.layout.activity_intro) {

    private val permissionRequestCode = 0
    private lateinit var acceptButton: Button

    private lateinit var dialog : PermissionDeniedDialog
    private val onAcceptClick = OnClickListener {
        ActivityCompat.requestPermissions(
            this@IntroActivity,
            arrayOf(
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ),
            permissionRequestCode
        )
    }

    private fun go() {
        Toast.makeText(this, "go", Toast.LENGTH_LONG).show()
    }

    override fun initViews() {
        acceptButton = findViewById(R.id.acceptButton)
        acceptButton.setOnClickListener(onAcceptClick)
    }

    override fun main() {
        dialog = PermissionDeniedDialog(packageName)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == permissionRequestCode) {

            for (p in grantResults) {
                if (p != PackageManager.PERMISSION_GRANTED) { // on of permissions not granted
                    dialog.show(supportFragmentManager, "tag")
                    return
                }
            }

            // granted all of permissions
            go()

        }
    }
}