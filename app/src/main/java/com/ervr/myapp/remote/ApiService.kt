package com.ervr.myapp.remote

import com.ervr.myapp.model.response.BreedImagesResponse
import com.ervr.myapp.model.response.BreedsResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("breeds/list/all")
    suspend fun getAllBreeds(): BreedsResponse

    @GET("breed/{breed}/images")
    suspend fun getBreedImages(@Path("breed") breed: String): BreedImagesResponse

}