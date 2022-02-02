package com.example.notepad.encrptiondecryption

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.notepad.R
import com.example.notepad.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding:ActivityHomeBinding
    companion object{
        private val context:HomeActivity?=null
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_home)
        binding.gotoenc.setOnClickListener {
            var intent= Intent(this,EncrptionActivity::class.java)
            startActivity(intent)
        }
        binding.gotodec.setOnClickListener {
            var intent= Intent(this,DecryptionActivity::class.java)
            startActivity(intent)
        }
    }
    }
