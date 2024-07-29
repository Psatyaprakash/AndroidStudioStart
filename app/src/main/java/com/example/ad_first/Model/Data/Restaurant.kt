package com.example.ad_first.Model.Data
import com.google.gson.annotations.SerializedName

data class RestaurantResponse(
    @SerializedName("restaurant") val restaurant: Restaurant
)

data class Restaurant(
    @SerializedName("name") val name: String,
    @SerializedName("location") val location: Location,
    @SerializedName("contact") val contact: Contact,
    @SerializedName("menu") val menu: List<MenuCategory>,
    @SerializedName("opening_hours") val openingHours: Map<String, String>,
    @SerializedName("reviews") val reviews: List<Review>
)

data class Location(
    @SerializedName("address") val address: String,
    @SerializedName("city") val city: String,
    @SerializedName("state") val state: String,
    @SerializedName("zipcode") val zipcode: String,
    @SerializedName("country") val country: String
)

data class Contact(
    @SerializedName("phone") val phone: String,
    @SerializedName("email") val email: String
)

data class MenuCategory(
    @SerializedName("category") val category: String,
    @SerializedName("items") val items: List<MenuItem>
)

data class MenuItem(
    @SerializedName("name") val name: String,
    @SerializedName("price") val price: Double,
    @SerializedName("images") val images: List<String>
)

data class Review(
    @SerializedName("user") val user: String,
    @SerializedName("rating") val rating: Double,
    @SerializedName("comment") val comment: String
)
