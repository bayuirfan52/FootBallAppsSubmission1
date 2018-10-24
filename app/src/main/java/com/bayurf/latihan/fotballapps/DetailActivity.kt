package com.bayurf.latihan.fotballapps

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*

/*
*
* Menggunakan Anko Layout dan Anko Commons
* Sumber deskripsi dari https://wikipedia.org
*
* */

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val item = intent.getParcelableExtra<Item>(MainActivity.PARCELABLE_ITEM_DATA)
        DetailUI(item).setContentView(this)
    }

    class DetailUI(val item : Item) : AnkoComponent<DetailActivity>{
        companion object {
            const val foto = 1
            const val nama = 2
            const val deskripsi= 3
        }
        override fun createView(ui: AnkoContext<DetailActivity>) = with(ui) {
            verticalLayout{
                padding = dip(10)
               imageView {
                    id = foto
                   Glide.with(this)
                       .load(item.foto)
                       .into(this)
                }.lparams(width = dip(120), height = dip(120)){
                    horizontalMargin = dip(5)
                    topMargin = dip(20)
                    gravity = Gravity.CENTER_HORIZONTAL
                }

               textView {
                    id = nama
                   text = item.nama
                    textSize = sp(12).toFloat()
                }.lparams(width = wrapContent,height = wrapContent){
                    topMargin = dip(10)
                    horizontalMargin = dip(15)
                    gravity = Gravity.CENTER_HORIZONTAL
                }

                textView {
                    id = deskripsi
                    text = item.deskripsi
                }.lparams(width = matchParent, height = wrapContent){
                    topMargin = dip(20)
                    horizontalMargin = dip(15)
                    gravity = Gravity.CENTER_HORIZONTAL
                }
            }
        }



    }
}