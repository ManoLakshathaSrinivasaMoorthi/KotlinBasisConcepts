package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    private var userName: EditText? = null
    private var passWord: EditText? = null
    private var loginBtn: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // initializing EditText and Button
        userName = findViewById(R.id.username);
        passWord = findViewById(R.id.password);
        loginBtn = findViewById(R.id.loginBtn);

        loginBtn!!.setOnClickListener {
            if (userName!!.getText().toString().equals("gfg")
                && passWord!!.getText().toString().equals("geeksforgeeks")
            ) {
                Toast.makeText(
                    MainActivity(),
                    "Modular Architecture Works Fine",
                    Toast.LENGTH_SHORT
                ).show();
            }
        }
    }
}