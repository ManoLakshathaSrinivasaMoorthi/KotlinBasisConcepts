package com.example.notepad.apiClient

import android.content.Context
import android.util.Log
import java.lang.Exception

class PrefUtility {
    private val TAG = PrefUtility::class.java.simpleName
    fun getStringInPref(context: Context, key: String?, defaultValue: String?): String? {
        try {
            val prefs = context.getSharedPreferences(key, Context.MODE_PRIVATE)
            return prefs.getString(key, defaultValue)
            //return getEncryptedStringInPref(context,key,defaultValue);
        } catch (e: Exception) {
            Log.e(TAG, "Exception:", e.cause)
        }
        return ""
    }

}
