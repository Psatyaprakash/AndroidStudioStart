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
import com.example.ad_first.Model.Data.User
import com.example.ad_first.Model.FetchUser.fetchUsers

@Composable
fun UserList() {

    val userList = remember {
        mutableStateOf<List<User>>(emptyList())
    }
    LaunchedEffect(Unit) {
        fetchUsers { user ->
            userList.value = user
        }
    }

    LazyColumn{
        items(userList.value) { user ->
            Text(
                text = "NAME: ${user.name}, Age: ${user.age}",
                fontSize = 20.sp,
                fontWeight = FontWeight.W500
            )
        }
    }
}