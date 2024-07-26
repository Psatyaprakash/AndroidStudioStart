package com.example.ad_first.Model.Repository

import com.example.ad_first.Model.API.ApiService
import com.example.ad_first.Model.Data.Restaurant

class ProductRepository(private val apiService: ApiService){
    suspend fun getRestaurants(): List<Restaurant>{
        return apiService.getRestaurants()
    }
}