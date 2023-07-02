package com.ervr.myapp.repository

import androidx.lifecycle.LiveData
import com.ervr.myapp.database.ItemDao
import com.ervr.myapp.model.Item

class ItemLocalRepository(private val itemDao: ItemDao) {

    val readAllData: LiveData<List<Item>> = itemDao.readAllData()

    suspend fun addItem(item: Item) {
        itemDao.addItem(item)
    }

    suspend fun deleteItem(item: Item) {
        itemDao.deleteItem(item)
    }

}