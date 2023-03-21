package com.example.catatnpenjualan.activity.barang.add

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.catatnpenjualan.R
import com.example.catatnpenjualan.base.BaseActivity
import com.example.catatnpenjualan.model.Barang
import com.google.android.material.snackbar.Snackbar
import java.util.*

class AddBarangActivity : BaseActivity(),AddBarangView {
    override fun onCreate(savedInstanceState: Bundle?) {
        cekSesi(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addbarang)

        setActionTambahButton()
    }

    private fun setActionTambahButton(){
        findViewById<Button>(R.id.btnAddBarang).setOnClickListener {
            findViewById<Button>(R.id.btnAddBarang).text = "Tambah"

            val barcode = findViewById<EditText>(R.id.etAddBarangBarcode).text.toString()
            val nama_barang = findViewById<EditText>(R.id.etAddBarangNamaBarang).text.toString()
            val kategori = findViewById<EditText>(R.id.etAddBarangKategori).text.toString()
            val harga_beli_s = findViewById<EditText>(R.id.etAddBarangHargaBeli).text.toString()
            val harga_jual_s = findViewById<EditText>(R.id.etAddBarangHargaJual).text.toString()

            if (harga_beli_s.isNotBlank()&&harga_jual_s.isNotBlank()) {
                val harga_beli = harga_beli_s.toDouble()
                val harga_jual = harga_jual_s.toDouble()

//            Buat Objeck Barang
                val barang = Barang()
                barang.idUser = user?.id_user.toString().toInt()
                barang.barcode = barcode
                barang.namaBarang = nama_barang.toUpperCase()
                barang.kategori = kategori.lowercase().capitalize()
                barang.hargaBeli = harga_beli
                barang.hargaJual = harga_jual

//            simpanke data base
                AddBarangPresenter(this@AddBarangActivity).addBarang(barang)
            }
            else {
//            jangan imputt
                Snackbar.make(it, "Harga Jangan Kosong", Snackbar.LENGTH_SHORT).show()
            }

        }
    }

    override fun onSuccessAddBarang(msg: String?) {
        Toast.makeText(this, "Berhasil", Toast.LENGTH_SHORT).show()
        finish()

    }

    override fun onErrorAddBarang(msg: String?) {
        Toast.makeText(this,"gagal",Toast.LENGTH_SHORT).show()
    }
}