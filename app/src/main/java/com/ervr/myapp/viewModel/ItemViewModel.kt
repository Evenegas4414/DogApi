package com.ervr.myapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ervr.myapp.model.Item
import com.ervr.myapp.repository.ItemRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class ItemViewModel(private val repository: ItemRepository) : ViewModel() {

    val myResponse: MutableLiveData<Response<List<Item>>> = MutableLiveData()

    fun getUser() {
        viewModelScope.launch {
            val response = repository.getItem()
            myResponse.value = response
        }
    }
}