package com.adematici.denemebankasi.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.adematici.denemebankasi.R
import com.adematici.denemebankasi.databinding.ActivityYetkiliMainBinding

class YetkiliMainActivity : AppCompatActivity() {

    lateinit var binding: ActivityYetkiliMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityYetkiliMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
    }

    fun hesapEkle(view: View){
        startActivity(Intent(this,HesapEkleActivity::class.java))
    }

    fun hesapSil(view: View){
        startActivity(Intent(this,HesapSilActivity::class.java))
    }

    fun hesaplariGoster(view: View){
        Toast.makeText(this,"Yakında Yapılacak",Toast.LENGTH_SHORT).show()
    }
}