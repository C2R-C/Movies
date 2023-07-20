package com.c2r.movies.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.c2r.movies.R
import io.github.cdimascio.dotenv.dotenv

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}