package com.ervr.myapp.repository

import com.ervr.myapp.model.Item
import com.ervr.myapp.remote.RetrofitInstance
import retrofit2.Response

class ItemRepository {

    suspend fun getItem(): Response<List<Item>> {
        return RetrofitInstance.api.getItem()
    }
}