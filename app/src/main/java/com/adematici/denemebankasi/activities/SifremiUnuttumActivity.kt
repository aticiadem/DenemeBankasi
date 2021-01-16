package com.adematici.denemebankasi.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.adematici.denemebankasi.R
import com.adematici.denemebankasi.database.Hesaplardao
import com.adematici.denemebankasi.database.VeritabaniYardimcisi
import com.adematici.denemebankasi.databinding.ActivitySifremiUnuttumBinding

class SifremiUnuttumActivity : AppCompatActivity() {

    lateinit var binding: ActivitySifremiUnuttumBinding
    val vt = VeritabaniYardimcisi(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySifremiUnuttumBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }


    fun yeniSifreOnayla(view: View){
        if(binding.etHesapNoSifremiUnuttum.text.isNotEmpty() && binding.etTcSifremiUnuttum.text.isNotEmpty() &&
                binding.etYeniSifreSifremiUnuttum.text.isNotEmpty()) {
            val hesapno = binding.etHesapNoSifremiUnuttum.text.toString().toInt()
            val tc = binding.etTcSifremiUnuttum.text.toString()
            val yenisifre = binding.etYeniSifreSifremiUnuttum.text.toString()

            val x = intent.getIntExtra("hesapno",0)
            val hesap = Hesaplardao().tekHesapGetir(vt,x)

            if(hesap != null){
                if(hesap.hesap_tc == tc && hesap.hesap_no == hesapno){
                    Hesaplardao().sifreDegis(vt,hesapno,yenisifre)
                    Toast.makeText(this,"Şifre Değiştirme Başarılı",Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this,GirisActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(this,"Hesap Bilgileri Yanlış!",Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this,"Hesap Bilgileri Yanlış!",Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this,"Lütfen Bütün Alanları Doldurun.",Toast.LENGTH_SHORT).show()
        }
    }


}