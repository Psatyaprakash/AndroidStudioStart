package com.example.ad_first.View

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.ad_first.Model.Data.Student
import com.example.ad_first.Model.FetchUser.fetchStudents

@Composable
fun StudentList() {

    val studentList = remember {
        mutableStateOf<List<Student>>(emptyList())
    }
    LaunchedEffect(Unit) {
        fetchStudents { stud ->
            studentList.value = stud
        }
    }

    LazyColumn{
        items(studentList.value) { student ->
            Text(
                text = "NAME: ${student.name}, Age: ${student.age} , Sic: ${student.sic}",
                fontSize = 20.sp,
                fontWeight = FontWeight.W500
            )
        }
    }
}