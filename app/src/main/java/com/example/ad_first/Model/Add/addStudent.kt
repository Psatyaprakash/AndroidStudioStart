package com.example.ad_first.Model.Add

import com.example.ad_first.Model.Data.Student
import com.example.ad_first.Model.FetchUser.db


fun addStudent(name: String, age: Int, sic: String) {
    val stud = Student(
        name,
        age,
        sic
    )  //user is an object of User class which takes the parameters name and age passed in addUser
    db.collection("Student")//"Student" is the collection name
        .document(sic)
        .set(stud)

}