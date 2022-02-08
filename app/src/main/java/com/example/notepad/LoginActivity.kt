package com.example.notepad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.content.Intent
import android.view.View
import com.example.login.MainActivity


class LoginActivity : AppCompatActivity() {
    private var modularText: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        modularText = findViewById(R.id.modularTextView)

        // adding listener to the button

        // adding listener to the button
        modularText!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                startActivity(Intent(LoginActivity(), MainActivity::class.java))
            }
        })
    }
}