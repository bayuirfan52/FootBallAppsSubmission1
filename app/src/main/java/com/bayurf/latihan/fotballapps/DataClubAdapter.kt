package com.bayurf.latihan.fotballapps

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.club_item.*

class DataClubAdapter (private val context : Context, private val items : List<Item>, private val listener : (Item) -> Unit ) :
    RecyclerView.Adapter<DataClubAdapter.ViewHolder>() {
    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bindItem(items[p1],listener)
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.club_item,p0,false))

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {

        fun bindItem(items : Item, listener : (Item) -> Unit){
            Glide.with(itemView.context)
                .load(items.foto)
                .into(image_data)
            name_club.text = items.nama

            containerView.setOnClickListener{ listener(items) }
        }
    }

}