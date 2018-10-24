package com.bayurf.latihan.fotballapps

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item (val foto: Int?, val nama: String?, val deskripsi:String?) : Parcelable