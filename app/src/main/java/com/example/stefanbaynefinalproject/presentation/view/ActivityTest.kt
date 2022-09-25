package com.example.stefanbaynefinalproject.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.stefanbaynefinalproject.R
// Second activity that receives information from the main Activity
class ActivityTest : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
    }

}