package com.example.ad_first.Model.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient{
//    private const val BASE_URL="https://fakestoreapi.com/"
   // private const val BASE_URL = "https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/"
private const val BASE_URL = "https://mocki.io/"
        val apiService: ApiService by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}