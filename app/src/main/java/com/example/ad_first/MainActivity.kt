package com.example.ad_first

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ad_first.View.AddStudentScreen
import com.example.ad_first.View.AddUserScreen
import com.example.ad_first.View.StudentList
import com.example.ad_first.View.UserList

class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        setContent {
            Column(
                Modifier
                    .padding(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                AddUserScreen()
                AddStudentScreen()
                Text(text = "User's List from Firestore", textAlign = TextAlign.Center, fontSize = 30.sp)
                UserList()
                Spacer(modifier = Modifier .height(10.dp))
                Text(text = "Students List" , textAlign = TextAlign.Center , fontSize = 30.sp)
                StudentList()
            }

        }
    }
}






