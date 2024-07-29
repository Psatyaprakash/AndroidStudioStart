package com.example.ad_first.ViewModel

import com.example.ad_first.Model.API.ApiService
import com.example.ad_first.Model.Data.Restaurant

class RestaurantRepository(private val apiService: ApiService) {
    suspend fun getRestaurants(): List<Restaurant> {
        return apiService.getRestaurants() // Make sure this matches the actual API call
    }
}


/*
class RestaurantViewModel : ViewModel(){
    private val _restaurant= MutableLiveData<List<Restaurant>>()
    val restaurants: LiveData<List<Restaurant>>
        get()= _restaurant
    private val repository= RestaurantRepository(RetrofitClient.apiService)

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
}*/