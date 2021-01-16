package com.adematici.denemebankasi.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.adematici.denemebankasi.R
import com.adematici.denemebankasi.database.Hesaplardao
import com.adematici.denemebankasi.database.VeritabaniYardimcisi
import com.adematici.denemebankasi.databinding.ActivityMusteriMainBinding

class MusteriMainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMusteriMainBinding
    var vt = VeritabaniYardimcisi(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMusteriMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        val x = intent.getIntExtra("hesapno",0)

        val isim = Hesaplardao().tekHesapGetir(vt,x)
        if(isim != null){
            binding.tvInToolbar.setText(isim.hesap_isim)
            binding.tvBakiye.text = "${isim.hesap_para}" + " TL"
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val x = intent.getIntExtra("hesapno",0)

        when (item.itemId){
            R.id.action_sifre_degis -> {
                val intent = Intent(this,SifremiUnuttumActivity::class.java)
                intent.putExtra("hesapno",x)
                startActivity(intent)
                return true
            }
            R.id.action_para_gonder -> {
                val intent = Intent(this,ParaGonderActivity::class.java)
                intent.putExtra("hesapno",x)
                startActivity(intent)
                return true
            }
            R.id.action_hesap_bilgileri -> {
                val intent = Intent(this,HesapBilgileriGosterMusteri::class.java)
                intent.putExtra("hesapno",x)
                startActivity(intent)
                return true
            }
            R.id.action_cikis -> {
                val intent = Intent(this,GirisActivity::class.java)
                startActivity(intent)
                finish()
                return true
            }
            else -> return false
        }
    }
}