package com.example.ad_first.Model.FetchUser

import android.content.ContentValues.TAG
import android.util.Log
import com.example.ad_first.Model.Data.Student

fun fetchStudents(onResult: (List<Student>) -> Unit) {
    db.collection("Student")
        .get()
        .addOnSuccessListener { result ->
            val studentList = result.map { document -> document.toObject(Student::class.java) }
            onResult(studentList)
        }
        .addOnFailureListener { e ->
            Log.w(TAG, "Error getting document", e)
        }
}