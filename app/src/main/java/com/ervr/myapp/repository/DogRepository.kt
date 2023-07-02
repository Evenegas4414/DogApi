package com.ervr.myapp.repository

import com.ervr.myapp.database.BreedDao
import com.ervr.myapp.model.Breed
import com.ervr.myapp.remote.ApiService

class DogRepository(private val dogApiService: ApiService, private val breedDao: BreedDao) {

    suspend fun getAllBreeds(): List<Breed> {
        val localBreeds = breedDao.getAllBreeds()
        if (localBreeds.isEmpty()) {
            val breedsResponse = dogApiService.getAllBreeds()
            val breeds = breedsResponse.message.keys.map { Breed(0, it) }
            breedDao.insertAll(breeds)
            return breedDao.getAllBreeds()
        }
        return localBreeds
    }
}