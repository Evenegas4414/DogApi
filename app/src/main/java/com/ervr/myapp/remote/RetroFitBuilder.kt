package com.ervr.myapp.remote

import com.ervr.myapp.util.Constant
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroFitBuilder {

    fun create(): ApiService {
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}