package com.example.ad_first.Model.Repository

import com.example.ad_first.Model.API.ApiService
import com.example.ad_first.Model.Data.Product

class ProductRepository(private val apiService: ApiService){
    suspend fun getProducts(): List<Product>{
        return apiService.getProducts()
    }
}