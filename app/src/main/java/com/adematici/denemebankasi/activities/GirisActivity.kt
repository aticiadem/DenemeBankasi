package com.adematici.denemebankasi.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.adematici.denemebankasi.R
import com.adematici.denemebankasi.database.Hesaplardao
import com.adematici.denemebankasi.database.VeritabaniYardimcisi
import com.adematici.denemebankasi.databinding.ActivityGirisBinding
import com.adematici.denemebankasi.model.Musteri

class GirisActivity : AppCompatActivity() {

    lateinit var binding: ActivityGirisBinding
    private val kullanici = "1234"
    private val sifre = "1234"

    private val vt: VeritabaniYardimcisi = VeritabaniYardimcisi(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityGirisBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    fun sifremiUnuttum(view: View){
        startActivity(Intent(this,SifremiUnuttumActivity::class.java))
    }

    fun yetkiliGirisi(view: View){
        if(binding.etTcGiris.text.toString() == kullanici && binding.etSifreGiris.text.toString() == sifre){
            Toast.makeText(this,"Giriş Başarılı",Toast.LENGTH_SHORT).show()
            startActivity(Intent(this,YetkiliMainActivity::class.java))
            finish()
        } else {
            Toast.makeText(this,"Giriş Başarısız",Toast.LENGTH_SHORT).show()
        }
    }

    fun musteriGirisi(view: View){
        if(binding.etTcGiris.text.isNotEmpty() && binding.etSifreGiris.text.isNotEmpty()){
            val hesaptc = binding.etTcGiris.text.toString()
            val hesapsifre = binding.etSifreGiris.text.toString()
            val x: Musteri? = Hesaplardao().tekTCGetir(vt,hesaptc)
            if (x != null) {
                if(x.hesap_tc == hesaptc && x.hesap_sifre == hesapsifre){
                    val intent = Intent(this,MusteriMainActivity::class.java)
                    intent.putExtra("hesapno",x.hesap_no)
                    startActivity(intent)
                    Toast.makeText(this,"Giriş Başarılı.",Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this,"Hesap Bilgileri Yanlış.",Toast.LENGTH_SHORT).show()
                }
            } else{
                Toast.makeText(this,"Hesap Bilgileri Yanlış.",Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this,"Bütün Alanları Doldurunuz.",Toast.LENGTH_SHORT).show()
        }
    }

}