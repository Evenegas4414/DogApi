package com.ervr.myapp.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.ervr.myapp.database.ItemDatabase
import com.ervr.myapp.model.Item
import com.ervr.myapp.repository.ItemLocalRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class LocalItemViewModel(application: Application) : AndroidViewModel(application) {

    var readAllData: LiveData<List<Item>>
    private val repository: ItemLocalRepository

    init {
        val itemDao = ItemDatabase.getDatabase(
            application
        ).itemDao()
        repository = ItemLocalRepository(itemDao)
        readAllData = repository.readAllData

    }

    fun addData(response: Response<List<Item>>) {
        viewModelScope.launch(Dispatchers.IO) {
            Log.i("DataBase Response", "data: " + response.body())
            val itemdata = response.body()
            if (itemdata != null) {
                for (i in 0 until (itemdata.count())) {
                    addItem(itemdata[i])
                    Log.i("DATA", "data: " + itemdata[i])
                }
            }


        }
    }

    fun addItem(item: Item) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addItem(item)
        }
    }

    fun deleteItem(item: Item) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteItem(item)
        }
    }


}