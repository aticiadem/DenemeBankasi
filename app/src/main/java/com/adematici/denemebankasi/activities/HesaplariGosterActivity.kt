package com.adematici.denemebankasi.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adematici.denemebankasi.databinding.ActivityHesaplariGosterBinding

class HesaplariGosterActivity : AppCompatActivity() {

    lateinit var binding: ActivityHesaplariGosterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHesaplariGosterBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        

    }
}