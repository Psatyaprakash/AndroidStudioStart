package com.example.ad_first.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ad_first.Model.API.RetrofitClient
import com.example.ad_first.Model.Data.Restaurant
import com.example.ad_first.Model.Repository.ProductRepository
import kotlinx.coroutines.launch

class ProductViewModel: ViewModel(){
    private val _restaurant= MutableLiveData<List<Restaurant>>()
    val restaurants: LiveData<List<Restaurant>>
        get()= _restaurant
    private val repository= ProductRepository(RetrofitClient.apiService)

    init {
        fetchRestaurants()
    }

    fun fetchRestaurants(){
        viewModelScope.launch {
            try {
                val restaurantList=repository.getRestaurants()
                _restaurant.postValue(restaurantList)
                println("API DATA CALLED: $restaurantList")
            }
            catch(e:Exception){
                println("Error: $e")
            }
        }
    }
}