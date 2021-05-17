package com.example.trainit

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.trainit.R
import android.Manifest
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat

/**
 * Main activity
 *
 * @constructor Create empty Main activity
 */
class MainActivity : AppCompatActivity() {
    val PERMISSION_ID = 42
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (!checkPermissions()) {
            requestPermissions()
        }
    }

    //skontroluje či mám povolenie na získanie polohy
    private fun checkPermissions(): Boolean {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            return true
        }
        return false
    }

    //ak nemám povolenie na získanie polohy, tak si ho vypýtam
    private fun requestPermissions() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION),
            PERMISSION_ID
        )
    }
}