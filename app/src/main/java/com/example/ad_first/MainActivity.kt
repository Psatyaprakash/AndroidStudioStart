package com.example.ad_first

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.auth.FirebaseAuth

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            ScaffoldExample()
                //loginScreen()

        }
    }
    val auth = FirebaseAuth.getInstance()
    fun signIn(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener { task ->
                if (task.user != null) {
                    println("User Logged In")
                    var user = auth.currentUser
                    println(user?.uid)
                }
            }
    }
    fun signUp(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener { task->

                if (task.user != null) {
                    println("User Created")
                    var user = auth.currentUser
                    println(user?.uid)
                }
            }
    }
/*    @Composable
    fun loginScreen() {
        val email = remember {
            mutableStateOf("")
        }
        val password = remember {
            mutableStateOf("")
        }
        Scaffold ( ){
                innerPadding ->
            Column(modifier = Modifier
                .padding(innerPadding)
                .padding(50.dp)
                .background(Color.Black)
            ) {
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                ) {
                    Column(modifier = Modifier.padding(10.dp)) {
                        TextField(
                            value = email.value,
                            onValueChange = { email.value = it },
                            label = { Text(text = "Email") },
                            modifier = Modifier
                                .fillMaxWidth()
                                //.clip(CircleShape)
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        OutlinedTextField(
                            value = password.value,
                            onValueChange = { password.value = it },
                            label = { Text(text = "Password") },
                            modifier = Modifier
                                .fillMaxWidth()
                                ,//.clip(CircleShape),
                            visualTransformation = PasswordVisualTransformation()
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(onClick = { signUp(email.value, password.value) }) {
                            Text(text = "Register")
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(onClick = { signIn(email.value, password.value) }) {
                            Text(text = "Login")
                        }
                    }
                }
            }
        }
    }
    */

    @Composable
    fun Card() {
        val email = remember {
            mutableStateOf("")
        }
        val password = remember {
            mutableStateOf("")
        }
        Column {
            ElevatedCard(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                ),
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),

                ) {
                Box(modifier = Modifier
                    .background(colorResource(id = R.color.Green3))
                ){
                    Column {
                        Text(
                            text = "Jetpack Compose ",
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxWidth(),
                            color = colorResource(id = R.color.teal_700),
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 30.sp,
                            textAlign = TextAlign.Center,
                        )
                        Column(modifier = Modifier
                            .fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                        }
                        Text(
                            text = "Login ",
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxWidth(),
                            textAlign = TextAlign.Start,
                            fontSize = 40.sp,
                            color = colorResource(id = R.color.teal_700)
                        )

                        Column(
                            modifier = Modifier
                                .padding(20.dp)
                                .fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            OutlinedTextField(value = email.value,
                                onValueChange = { email.value = it },
                                label = {
                                    Text(
                                        "Email Id or Mobile no. ",
                                        fontSize = 20.sp
                                    )
                                },
                                placeholder = { Text(text = "xyz@gmail.com")}
                            )
                            //Text(text)
                            Spacer(modifier = Modifier.height(20.dp))

                            OutlinedTextField(
                                value = password.value,
                                trailingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = null) },
                                onValueChange = {
                                    password.value = it
                                },
                                label = { Text(text = "Password") },
                                placeholder = { Text(text = "Enter your Password") },
                            )

                        }
                        Text(
                            text = "Forgot Pasword ? ",
                            modifier = Modifier
                                .padding(5.dp)
                                .fillMaxWidth(),
                            textAlign = TextAlign.End,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.W700 ,
                            color = colorResource(id = R.color.teal_700)
                        )

                        Button(onClick = {
                            signUp(email.value, password.value)
                            println("Login")
                            } ,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(id = R.color.L_Blue)
                            ),
                            modifier = Modifier
                                .padding(20.dp)
                                .width(130.dp)
                                .height(60.dp)

                        ) {
                            Text(text = "Login" , fontSize = 20.sp)
                        }
                    }
                }
            }//Card End
            Spacer(modifier = Modifier.height(30.dp))
            Row(modifier = Modifier
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "Don't have an account ? " , fontSize = 18.sp)
                Text(text = " Register" , fontSize = 18.sp, fontWeight = FontWeight.W700, color = colorResource(
                    id = R.color.teal_700) )
            }

        }
    }




    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ScaffoldExample() {
        Scaffold(
            topBar = {
                TopAppBar(
                    colors = topAppBarColors(
                        containerColor = colorResource(id = R.color.teal_700),
                        titleContentColor = colorResource(id = R.color.Green3),
                    ),

                    title = {
                        Text("Jetpack",
                            textAlign = TextAlign.Center,
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,)
                    }
                )
            },
            bottomBar = {
                BottomAppBar(
                    containerColor = colorResource(id = R.color.teal_700),
                    contentColor = colorResource(id = R.color.Green2),
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        text = "Register",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        //color = colorResource(id = R.color.teal_700)
                    )
                }
            },
            floatingActionButton = {
                FloatingActionButton(onClick = {}) {
                    Box(modifier = Modifier
                        .background(colorResource(id = R.color.Green3 ))
                        .size(60.dp) ,
                        Alignment.Center
                    ){
                        Icon(Icons.Default.Call, contentDescription = "Add")
                    }
                }
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {

                //Start of task app

                Column (
                    modifier = Modifier
                        .padding(10.dp)
                ) {
                    Card()
                }


                //End of task app

            }
        }
    }
}