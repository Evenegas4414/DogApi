package com.ervr.myapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ervr.myapp.model.Breed

@Database(entities = [Breed::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun breedDao(): BreedDao
}