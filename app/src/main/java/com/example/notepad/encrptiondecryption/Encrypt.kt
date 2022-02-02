package com.example.notepad.encrptiondecryption

import java.lang.Exception
import javax.crypto.Cipher
import javax.crypto.SecretKey
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

class Encrypt {
    @Throws(Exception::class)
    fun encrypt(plaintext: ByteArray, key: SecretKey, IV: ByteArray?): ByteArray? {
        val cipher = Cipher.getInstance("AES")

        val keySpec = SecretKeySpec(key.encoded, "AES")

        val ivSpec = IvParameterSpec(IV)

        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec)
        return cipher.doFinal(plaintext)
    }
}