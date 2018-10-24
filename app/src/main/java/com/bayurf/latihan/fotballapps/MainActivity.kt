package com.bayurf.latihan.fotballapps

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

/*
*
* Menggunakan layuout XML
* Untuk belajar lebih jauh Mengkaitkan XML dengan Kotlin
*
* */

class MainActivity : AppCompatActivity() {
    companion object {
        const val PARCELABLE_ITEM_DATA = "Item"
    }
    var items : MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        masukkanData()

        list_data.layoutManager = LinearLayoutManager(this)
        list_data.adapter = DataClubAdapter(this, items){
            startActivity<DetailActivity>(PARCELABLE_ITEM_DATA to it)
        }
    }

    private fun masukkanData(){
        val foto = resources.obtainTypedArray(R.array.daftar_foto)
        val nama = resources.getStringArray(R.array.daftar_club)
        val deskripsi = resources.getStringArray(R.array.detail_club)

        items.clear()

        for (i in nama.indices){
            items.add(Item (foto.getResourceId(i,0),nama[i],deskripsi[i]))
        }

        foto.recycle()
    }
}
