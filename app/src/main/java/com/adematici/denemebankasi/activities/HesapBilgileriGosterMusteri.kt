package com.adematici.denemebankasi.activities

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.adematici.denemebankasi.database.Hesaplardao
import com.adematici.denemebankasi.database.VeritabaniYardimcisi
import com.adematici.denemebankasi.databinding.ActivityHesapBilgileriGosterMusteriBinding

class HesapBilgileriGosterMusteri : AppCompatActivity() {

    lateinit var binding: ActivityHesapBilgileriGosterMusteriBinding
    val vt = VeritabaniYardimcisi(this)

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHesapBilgileriGosterMusteriBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val x = intent.getIntExtra("hesapno",0)
        val hesap = Hesaplardao().tekHesapGetir(vt,x)

        if(hesap != null){
            binding.etIsimSoyisimHesapBilgisi.setText("İsim: ${hesap.hesap_isim}")
            binding.etTCHesapBilgisi.setText("T.C: ${hesap.hesap_tc}")
            binding.etDTHesapBilgisi.setText("Doğum Tarihi: ${hesap.hesap_dt}")
            binding.etParaHesapBilgisi.setText("Bulunan Para: ${hesap.hesap_para}")
            binding.etHesapNoHesapBilgisi.setText("Hesap No.: ${hesap.hesap_no}")
        } else {
            Toast.makeText(this,"Hata!",Toast.LENGTH_SHORT).show()
        }
    }
}