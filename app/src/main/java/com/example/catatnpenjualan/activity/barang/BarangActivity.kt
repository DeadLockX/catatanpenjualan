package com.example.catatnpenjualan.activity.barang


import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.catatnpenjualan.R
import com.example.catatnpenjualan.activity.barang.add.AddBarangActivity
import com.example.catatnpenjualan.base.BaseActivity
import com.example.catatnpenjualan.model.Barang
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BarangActivity : BaseActivity(), DataBarangView {
    override fun onCreate(savedInstanceState: Bundle?) {
        cekSesi(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_barang)

        refreshBarang()
        addBarang()

        findViewById<FloatingActionButton>(R.id.btn_databarang).setOnClickListener{
            val intent = Intent(this, AddBarangActivity::class.java)
            intent.putExtra(TAGS.USER,user)
            startActivity(intent)
        }
    }
    private fun refreshBarang() {
        DataBarangPresenter(this).getDataBarang(user)
    }

    override fun onSuccessDataBarang(data:List<Barang?>?){
        findViewById<RecyclerView>(R.id.rvDataBarang).adapter=DataBarangAdapter(data,object : DataBarangAdapter.OnMenuClicked{
            override fun click (menuItem:MenuItem, barang: Barang?){
            when(menuItem.itemId){
                R.id.editbarang->editBarang(barang)
                R.id.hapusbarang->hapusBarang(barang)
            }
        }
    })
    }

    override fun onErrorDataBarang(msg:String?){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    private fun addBarang(){
        findViewById<FloatingActionButton>(R.id.btn_databarang).setOnClickListener{
            val intent = Intent(this,AddBarangActivity::class.java).apply {
                putExtra(TAGS.USER, user)
            }
            startActivity(intent)
        }
    }

    private fun editBarang(barang:Barang?){
    }

    private fun hapusBarang(barang:Barang?){
    }

    override fun onResume(){
        super.onResume()
        refreshBarang()
    }


}