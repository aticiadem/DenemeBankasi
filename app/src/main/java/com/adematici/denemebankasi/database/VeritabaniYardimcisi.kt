package com.adematici.denemebankasi.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class VeritabaniYardimcisi (context: Context) : SQLiteOpenHelper(context,"denemebankasi",null,1){
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE hesaplar(hesap_no INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "hesap_isim TEXT, " +
                "hesap_tc TEXT, " +
                "hesap_sifre TEXT, " +
                "hesap_dt TEXT, " +
                "hesap_para Int);")
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS hesaplar")
        onCreate(db)
    }
}