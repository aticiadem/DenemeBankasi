package com.adematici.denemebankasi.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.adematici.denemebankasi.database.Hesaplardao
import com.adematici.denemebankasi.database.VeritabaniYardimcisi
import com.adematici.denemebankasi.databinding.ActivityHesapSilBinding

class HesapSilActivity : AppCompatActivity() {

    lateinit var binding: ActivityHesapSilBinding
    val vt = VeritabaniYardimcisi(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHesapSilBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btHesabiSil.setOnClickListener {
            if(binding.etHesapNoHesapSil.text.isNotEmpty() && binding.etTCHesapSil.text.isNotEmpty()){
                val hesapno = binding.etHesapNoHesapSil.text.toString().toInt()
                val hesaptc = binding.etTCHesapSil.text.toString()

                val x = Hesaplardao().tekHesapGetir(vt,hesapno)
                if(x != null){
                    if(x.hesap_tc == hesaptc && x.hesap_no == hesapno){
                        Hesaplardao().hesapSil(vt,hesapno)
                        Toast.makeText(this,"Hesap Silme Başarılı",Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this,YetkiliMainActivity::class.java))
                        finish()
                    }
                } else {
                    Toast.makeText(this,"Yanlış Hesap Bilgisi",Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this,"Bütün Alanları Doldurunuz.",Toast.LENGTH_SHORT).show()
            }
        }

    }
}