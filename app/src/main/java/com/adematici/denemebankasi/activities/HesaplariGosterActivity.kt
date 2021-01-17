package com.adematici.denemebankasi.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.adematici.denemebankasi.adapter.HesapGosterAdapter
import com.adematici.denemebankasi.database.Hesaplardao
import com.adematici.denemebankasi.database.VeritabaniYardimcisi
import com.adematici.denemebankasi.databinding.ActivityHesaplariGosterBinding
import com.adematici.denemebankasi.model.Musteri

class HesaplariGosterActivity : AppCompatActivity() {

    lateinit var binding: ActivityHesaplariGosterBinding
    val vt = VeritabaniYardimcisi(this)
    private lateinit var adapter: HesapGosterAdapter
    private lateinit var hesapListesi: ArrayList<Musteri>

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHesaplariGosterBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        hesapListesi = ArrayList()
        hesapListesi = Hesaplardao().tumHesaplar(vt)
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = HesapGosterAdapter(this,hesapListesi)
        binding.recyclerView.adapter = adapter
    }

}