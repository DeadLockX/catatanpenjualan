package com.example.catatnpenjualan.activity.barang.add

import NetworkConfig
import android.util.Log
import com.example.catatnpenjualan.model.Barang
import com.example.catatnpenjualan.utils.ResultSimple
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddBarangPresenter(val addBarangView:AddBarangView){
    fun addBarang(dataBarang : Barang){
        NetworkConfig.service()
            .addBarang(dataBarang.idUser,
                dataBarang.barcode,
                dataBarang.namaBarang,
                dataBarang.kategori,
                dataBarang.hargaBeli,
                dataBarang.hargaJual)
            .enqueue(object : Callback<ResultSimple> {
                override fun onFailure(call: Call<ResultSimple>, t: Throwable) {
                    addBarangView.onErrorAddBarang(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<ResultSimple>,
                    response: Response<ResultSimple>
                ) {
                    val body = response.body()
                    if (body?.status == "200"){
                        Log.d("error", body.status)
                        addBarangView.onSuccessAddBarang(body.pesan) }

                    else {
                        println("error $body")
                        body?.status?.let { Log.d("error", it) }
                        addBarangView.onErrorAddBarang(body?.pesan) }

            }
    })
}





}