package com.adematici.denemebankasi.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.adematici.denemebankasi.database.Hesaplardao
import com.adematici.denemebankasi.database.VeritabaniYardimcisi
import com.adematici.denemebankasi.databinding.ActivityParaGonderBinding

class ParaGonderActivity : AppCompatActivity() {

    lateinit var binding: ActivityParaGonderBinding
    val vt = VeritabaniYardimcisi(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityParaGonderBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btParaGonder.setOnClickListener {
            if(binding.etHesapNoParaGonder.text.isNotEmpty() && binding.etTutarParaGonder.text.isNotEmpty()){
                val aliciHesapNo = binding.etHesapNoParaGonder.text.toString().toInt()
                val gonderilenParaMiktari = binding.etTutarParaGonder.text.toString().toInt()

                if(gonderilenParaMiktari>0){
                    val gonderenHesapNo = intent.getIntExtra("hesapno",0)
                    val gonderenHesapBilgisi = Hesaplardao().tekHesapGetir(vt,gonderenHesapNo)
                    val aliciHesapBilgisi = Hesaplardao().tekHesapGetir(vt,aliciHesapNo)
                    // para gönderen
                    if(gonderenHesapBilgisi != null){
                        val aktifpara = gonderenHesapBilgisi.hesap_para
                        val yenipara = aktifpara - gonderilenParaMiktari
                        if(yenipara > 0){
                            Toast.makeText(this,"Gönderim Başarılı.",Toast.LENGTH_SHORT).show()
                            Hesaplardao().hesapParaGuncelle(vt,gonderenHesapNo,yenipara)
                            val intent = Intent(this,MusteriMainActivity::class.java)
                            intent.putExtra("hesapno",gonderenHesapNo)
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(this,"Yeterli Para Yok.",Toast.LENGTH_SHORT).show()
                        }
                    }
                    // para alan
                    if(aliciHesapBilgisi != null){
                        val aktifpara = aliciHesapBilgisi.hesap_para
                        val yenipara = aktifpara + gonderilenParaMiktari
                        Hesaplardao().hesapParaGuncelle(vt,aliciHesapNo,yenipara)
                    } else {
                        Toast.makeText(this,"Hata!",Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this,"Lütfen Geçerli Miktar Giriniz.",Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this,"Bütün Alanları Doldurunuz.",Toast.LENGTH_SHORT).show()
            }
        }
    }
}