package com.example.ad_first.Model.API

import com.example.ad_first.Model.Data.Restaurant
import retrofit2.http.GET


interface ApiService {
    @GET("v1/a1fa74c5-a430-41d6-9959-6847d89cdda0")
    suspend fun fetchRestaurants(): List<Restaurant>
    abstract fun getRestaurants(): List<Restaurant>
}
