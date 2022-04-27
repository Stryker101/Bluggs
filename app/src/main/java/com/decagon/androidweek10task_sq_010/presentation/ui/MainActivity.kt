package com.decagon.androidweek10task_sq_010.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.decagon.androidweek10task_sq_010.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
