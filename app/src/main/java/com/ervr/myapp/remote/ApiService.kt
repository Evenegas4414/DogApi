package com.ervr.myapp.remote

import com.ervr.myapp.model.response.BreedsResponse
import retrofit2.http.GET

interface ApiService {
    @GET("breeds/list/all")
    suspend fun getAllBreeds(): BreedsResponse
}