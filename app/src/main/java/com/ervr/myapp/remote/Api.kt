package com.ervr.myapp.remote

import com.ervr.myapp.model.Item
import com.ervr.myapp.util.Constant
import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET(Constant.URL_SELECT)
    suspend fun getItem(): Response<List<Item>>
}