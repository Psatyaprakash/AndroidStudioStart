package com.example.ad_first.Model.FetchUser

import android.content.ContentValues.TAG
import android.util.Log
import com.example.ad_first.Model.Data.User
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

val db = Firebase.firestore


fun fetchUsers(onResult: (List<User>) -> Unit) {
    db.collection("users")
        .get()
        .addOnSuccessListener { result ->
            val userList = result.map { document -> document.toObject(User::class.java) }
            onResult(userList)
        }
        .addOnFailureListener { e ->
            Log.w(TAG, "Error getting document", e)
        }
}