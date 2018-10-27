package com.example.eko.clubfootball

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item (val name: String, val image: Int, val keterangan: String) : Parcelable