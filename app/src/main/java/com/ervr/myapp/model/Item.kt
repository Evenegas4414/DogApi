package com.ervr.myapp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class Item(

    @PrimaryKey(autoGenerate = false)
    val name: String
) : Parcelable