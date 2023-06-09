package com.example.catatnpenjualan.activity.barang

import com.example.catatnpenjualan.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataBarangPresenter(val dataBarangView: DataBarangView) {
    fun getDataBarang(user: User?){
        NetworkConfig.service()
            .getDataBarang(user?.id_user)
            .enqueue(object: Callback<ResultDataBarang> {
                override fun onResponse(call: Call<ResultDataBarang>, response: Response<ResultDataBarang>) {
                    val body = response.body()
                    dataBarangView.onSuccessDataBarang(body?.barang)
                }

                override fun onFailure(call: Call<ResultDataBarang>, t: Throwable) {
                    dataBarangView.onErrorDataBarang(t.localizedMessage)
                }

            })
    }
}