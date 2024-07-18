package com.example.ad_first.Model.Data

data class Product(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val category: String,
    val image: String,
    val rating: Ratings
)
data class Ratings(
    val rate: Double,
    val count: Int
)