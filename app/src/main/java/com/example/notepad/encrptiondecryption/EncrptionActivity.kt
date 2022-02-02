package com.example.notepad.encrptiondecryption

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Base64
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.notepad.R
import com.example.notepad.databinding.ActivityEncrptionBinding
import java.security.NoSuchAlgorithmException
import java.security.SecureRandom
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey

class EncrptionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEncrptionBinding
    var keyGenerator: KeyGenerator?=null
    var secretKey: SecretKey?=null
    var secretKeyen= byteArrayOf()
    var strSecretKey:String?=null
    var IV= byteArrayOf(16)
    var cipherText= byteArrayOf()
    var random: SecureRandom?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_encrption)
        binding.encBtn.setOnClickListener {
            var encode=binding.etOrjText.text
            if(TextUtils.isEmpty(binding.etOrjText.text))
            {
                Toast.makeText(this,"Fill empty field", Toast.LENGTH_LONG).show()
            }
            else
            {
                try{
                    keyGenerator= KeyGenerator.getInstance("AES")
                }
                catch (e: NoSuchAlgorithmException)
                {
                    e.printStackTrace()
                }
                keyGenerator?.init(256)
                secretKey=keyGenerator?.generateKey()
                secretKeyen= secretKey?.encoded!!
                strSecretKey=encoderfun(secretKeyen)
                binding.secretkey.text=strSecretKey
                random= SecureRandom()
                random?.nextBytes(IV)
                try{
                    cipherText= Encrypt().encrypt(binding.etOrjText.text.toString().trim().toByteArray(),
                        secretKey!!,IV)!!
                    var sonuc:String?=encoderfun(cipherText)
                    binding.sonuc.text=sonuc
                    var tvIV=encoderfun(IV)
                    binding.anahtar.text=tvIV
                    sonuc?.let { it1 -> strSecretKey?.let { it2 ->
                        tvIV?.let { it3 ->
                            Utils().saveData(this, it1,
                                it2, it3
                            )
                        }
                    } }

                }catch (e :Exception)
                {
                    e.printStackTrace()
                }
            }
        }
    }
    private fun encoderfun(secretKeyen: ByteArray): String? {
        var conVal:String= Base64.encodeToString(secretKeyen, Base64.DEFAULT)
        return conVal
    }
}