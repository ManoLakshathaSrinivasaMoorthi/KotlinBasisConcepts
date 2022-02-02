package com.example.notepad.encrptiondecryption

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Base64
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.notepad.R
import com.example.notepad.databinding.ActivityDecryptionBinding
import javax.crypto.SecretKey
import javax.crypto.spec.SecretKeySpec

class DecryptionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDecryptionBinding
    private var decryptedText:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_decryption)
        var list:List<String?> =Utils().getData(this)
        if(list.size>0)
        {
            binding.etEncText.setText(list.get(0))
            binding.etSecretKey.setText(list.get(1))
            binding.etAnahtar.setText(list.get(2))
        }
        binding.decBtn.setOnClickListener {
            btnDecodeClick()

        }
    }
    private fun btnDecodeClick() {
        if((TextUtils.isEmpty(binding.etEncText.text)) || (TextUtils.isEmpty(binding.etAnahtar.text)) || (TextUtils.isEmpty(binding.etSecretKey.text)))
        {
            Toast.makeText(this,"Fill empty fields", Toast.LENGTH_LONG).show()


        }
        else
        {
            try{
                var strEncText=binding.etEncText.text.toString().trim()
                val encText: ByteArray = decoderfun(strEncText)
                val strAnahtar: String =binding.etAnahtar.getText().toString().trim { it <= ' ' }
                val iv: ByteArray = decoderfun(strAnahtar)
                val strSecretKey: String = binding.etSecretKey.getText().toString().trim { it <= ' ' }
                val encodedSecretKey: ByteArray = decoderfun(strSecretKey)
                val originalSecretKey: SecretKey = SecretKeySpec(encodedSecretKey, 0, encodedSecretKey.size, "AES")

                decryptedText = Decrypt().decrypt(encText, originalSecretKey, iv)
                binding.tvOrjText.setText(decryptedText)
            }
            catch (e:Exception)
            {
                e.printStackTrace()
            }
        }
    }

    private fun decoderfun(strEncText: String): ByteArray {
        var conval:ByteArray= Base64.decode(strEncText, Base64.DEFAULT)
        return conval
    }
}