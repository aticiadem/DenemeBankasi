package com.adematici.denemebankasi.database

import android.content.ContentValues
import com.adematici.denemebankasi.model.Musteri

class Hesaplardao  {

    fun hesapEkle(vt: VeritabaniYardimcisi, hesap_isim: String, hesap_tc: String, hesap_sifre: String, hesap_dt: String, hesap_para: Int){
        val db = vt.writableDatabase
        val values = ContentValues()

        values.put("hesap_isim",hesap_isim)
        values.put("hesap_tc",hesap_tc)
        values.put("hesap_sifre",hesap_sifre)
        values.put("hesap_dt",hesap_dt)
        values.put("hesap_para",hesap_para)

        db.insertOrThrow("hesaplar",null,values)
        db.close()
    }

    fun tumHesaplar(vt: VeritabaniYardimcisi) : ArrayList<Musteri>{
        val hesaplarArrayList = ArrayList<Musteri>()
        val db = vt.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM hesaplar",null)

        while (cursor.moveToNext()){
            val hesap = Musteri(cursor.getInt(cursor.getColumnIndex("hesap_no")),
                cursor.getString(cursor.getColumnIndex("hesap_isim")),
                cursor.getString(cursor.getColumnIndex("hesap_tc")),
                cursor.getString(cursor.getColumnIndex("hesap_sifre")),
                cursor.getString(cursor.getColumnIndex("hesap_dt")),
                cursor.getInt(cursor.getColumnIndex("hesap_para")))
            hesaplarArrayList.add(hesap)
        }
        return hesaplarArrayList
    }

    fun hesapSil(vt: VeritabaniYardimcisi, hesap_no: Int){
        val db = vt.writableDatabase
        db.delete("hesaplar","hesap_no=?", arrayOf(hesap_no.toString()))
        db.close()
    }

    fun tekHesapGetir(vt:VeritabaniYardimcisi, hesap_no: Int) : Musteri? {
        var gelenKisi: Musteri? = null
        val db = vt.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM hesaplar WHERE hesap_no=$hesap_no",null)

        while (cursor.moveToNext()){
            gelenKisi = Musteri(cursor.getInt(cursor.getColumnIndex("hesap_no")),
                    cursor.getString(cursor.getColumnIndex("hesap_isim")),
                    cursor.getString(cursor.getColumnIndex("hesap_tc")),
                    cursor.getString(cursor.getColumnIndex("hesap_sifre")),
                    cursor.getString(cursor.getColumnIndex("hesap_dt")),
                    cursor.getInt(cursor.getColumnIndex("hesap_para")))
        }
        return gelenKisi
    }

    fun tekTCGetir(vt:VeritabaniYardimcisi, hesap_tc: String) : Musteri? {
        var gelenKisi: Musteri? = null
        val db = vt.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM hesaplar WHERE hesap_tc=$hesap_tc",null)

        while (cursor.moveToNext()){
            gelenKisi = Musteri(cursor.getInt(cursor.getColumnIndex("hesap_no")),
                    cursor.getString(cursor.getColumnIndex("hesap_isim")),
                    cursor.getString(cursor.getColumnIndex("hesap_tc")),
                    cursor.getString(cursor.getColumnIndex("hesap_sifre")),
                    cursor.getString(cursor.getColumnIndex("hesap_dt")),
                    cursor.getInt(cursor.getColumnIndex("hesap_para")))
        }
        return gelenKisi
    }

    fun sifreDegis(vt: VeritabaniYardimcisi, hesap_no: Int, hesap_sifre: String){
        val db = vt.writableDatabase
        val values = ContentValues()

        values.put("hesap_no", hesap_no)
        values.put("hesap_sifre", hesap_sifre)

        db.update("hesaplar",values,"hesap_no=?", arrayOf(hesap_no.toString()))
        db.close()
    }

    fun hesapParaGuncelle(vt: VeritabaniYardimcisi, hesap_no: Int, hesap_para: Int){
        val db = vt.writableDatabase
        val values = ContentValues()

        values.put("hesap_no", hesap_no)
        values.put("hesap_para", hesap_para)

        db.update("hesaplar",values,"hesap_no=?", arrayOf(hesap_no.toString()))
        db.close()
    }

}