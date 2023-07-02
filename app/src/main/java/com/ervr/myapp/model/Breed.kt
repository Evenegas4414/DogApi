package com.ervr.myapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Breed(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val breed: String
)