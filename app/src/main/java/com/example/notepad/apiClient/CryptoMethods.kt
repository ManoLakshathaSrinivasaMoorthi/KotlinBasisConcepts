package com.example.notepad.apiClient

import java.lang.Exception

interface  CryptoMethods {
    @Throws(Exception::class)
    fun encrypt(body: String?): String?

    @Throws(Exception::class)
    fun decrypt(data: String?): String?
}
