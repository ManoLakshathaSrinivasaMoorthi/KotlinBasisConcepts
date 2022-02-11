package com.example.notepad.receivers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.notepad.R

class BroastCastReceiversActivity : AppCompatActivity() {
    var btn: Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broast_cast_receivers)
        btn=findViewById(R.id.broadCast)
        btn?.setOnClickListener {
            onBroadcastSendBtnClicked();
        }
    }

    private fun onBroadcastSendBtnClicked() {
    val intent=Intent()
        intent.setAction("com.example.myBroadcastMessage")
        intent.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES)
        sendBroadcast(intent)
    }
}