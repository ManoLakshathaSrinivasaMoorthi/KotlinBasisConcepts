package com.example.notepad.encrptiondecryption

import android.content.Context
import android.content.SharedPreferences

class Utils {
    private var preferences : SharedPreferences? = null

    private fun init(context: Context) {
        preferences = context.getSharedPreferences("ENCRYPT", Context.MODE_PRIVATE)
    }



    fun saveData(context: Context, text : String, secreteKey : String, iv : String) {
        init(context)
        with(preferences?.edit()){
            this?.putString("text", text)
            this?.putString("secreteKey", secreteKey)
            this?.putString("iv", iv)
            this?.commit()
        }

    }


    fun getData(context: Context) : List<String?> {
        init(context)
        with(preferences) {
            return listOf(
                this?.getString("text", ""),
                this?.getString("secreteKey", ""),
                this?.getString("iv", ""))
        }
    }

}