package com.adematici.denemebankasi.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.adematici.denemebankasi.database.Hesaplardao
import com.adematici.denemebankasi.database.VeritabaniYardimcisi
import com.adematici.denemebankasi.databinding.ActivityHesapEkleBinding

class HesapEkleActivity : AppCompatActivity() {

    lateinit var binding: ActivityHesapEkleBinding

    val vt = VeritabaniYardimcisi(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHesapEkleBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btHesabiEkle.setOnClickListener {
            if(binding.etIsimSoyisimHesapEkle.text.isNotEmpty() && binding.etTCHesapEkle.text.isNotEmpty() &&
                    binding.etSifreHesapEkle.text.isNotEmpty() && binding.etDTHesapEkle.text.isNotEmpty()) {
                val isim = binding.etIsimSoyisimHesapEkle.text.toString()
                val tc = binding.etTCHesapEkle.text.toString()
                val sifre = binding.etSifreHesapEkle.text.toString()
                val dt = binding.etDTHesapEkle.text.toString()

                Hesaplardao().hesapEkle(vt,isim,tc,sifre,dt,0)

                Toast.makeText(this,"Kayıt Başarılı",Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,YetkiliMainActivity::class.java))
                finish()
            } else {
                Toast.makeText(this,"Lütfen Bütün Alanları Doldurunuz.", Toast.LENGTH_SHORT).show()
            }
        }


    }
}