package com.ervr.myapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ervr.myapp.model.Breed

@Dao
interface BreedDao {
    @Query("SELECT * FROM Breed")
    suspend fun getAllBreeds(): List<Breed>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(breeds: List<Breed>)
}