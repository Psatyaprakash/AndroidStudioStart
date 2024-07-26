package com.example.ad_first.Model.Data

data class Restaurant(
    val name : String,
    val location : location,
    val contact :Contact,
    val menu : Menu,
    val opening_hours : Hour,
    val reviews : Review,
)
data class Contact(
    val phone : Int,
    val email : String
)
data class location(
    val address : String,
    val city : String,
    val state : String,
    val zipcode : Int,
    val country : String
)
data class Menu(
    val category: String,
    val items : Items,

    )
data class Items(
    val name: String,
    val price : Double,
    val images : String
)
data class Review(
    val user :String,
    val rating : Double,
    val comment : String
)
data class Hour(
    val Monday : String,
    val Tuesday : String,
    val Wednesday : String,
    val Thursday : String,
    val Friday : String,
    val Saturday : String,
    val Sunday : String
)