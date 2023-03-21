package com.example.catatnpenjualan.activity.barang

import com.example.catatnpenjualan.model.Barang

interface DataBarangView {
    fun onSuccessDataBarang(data:List<Barang?>?)
    fun onErrorDataBarang(msg:String?)
}