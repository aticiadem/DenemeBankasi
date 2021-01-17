package com.adematici.denemebankasi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adematici.denemebankasi.databinding.HesapGosterRowBinding
import com.adematici.denemebankasi.model.Musteri

class HesapGosterAdapter(private val mContext: Context, private val hesapListesi: ArrayList<Musteri>) : RecyclerView.Adapter<HesapGosterAdapter.HesapGoster>() {

    class HesapGoster(val itemBinding: HesapGosterRowBinding) : RecyclerView.ViewHolder(itemBinding.root){
    }

    override fun getItemCount(): Int {
        return hesapListesi.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HesapGoster {
        val binding = HesapGosterRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return HesapGoster(binding)
    }

    override fun onBindViewHolder(holder: HesapGoster, position: Int) {
        holder.itemBinding.tvIsimSoyisim.text = hesapListesi[position].hesap_isim
        holder.itemBinding.tvTC.text = hesapListesi[position].hesap_tc
        holder.itemBinding.tvPara.text = hesapListesi[position].hesap_para.toString()
    }

}