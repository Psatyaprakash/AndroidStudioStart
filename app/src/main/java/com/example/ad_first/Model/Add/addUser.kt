package com.example.ad_first.Model.Add

import android.content.ContentValues.TAG
import android.util.Log
import com.example.ad_first.Model.Data.User
import com.example.ad_first.Model.FetchUser.db

fun addUser(name: String, age: Int) {
    val user = User(
        name,
        age
    )  //user is an object of User class which takes the parameters name and age passed in addUser
    db.collection("users")//"users" is the collection name
        .add(user)
        .addOnSuccessListener { docRef ->
            Log.d(TAG, "DOCUMENT SNAPSHOT ADDED WITH ID: ${docRef.id}")
        }
        .addOnFailureListener { e ->
            Log.w(TAG, "Error Adding Document")

        }
}