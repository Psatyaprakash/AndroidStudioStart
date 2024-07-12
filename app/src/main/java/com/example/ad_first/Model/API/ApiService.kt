package com.example.ad_first.Model.API

import com.example.ad_first.Model.Data.Product
import retrofit2.http.GET

interface ApiService{
    @GET("Products")
    suspend fun getProducts(): List<Product>
//    @GET("Users")
//    suspend fun getProducts(): List<Product>
}