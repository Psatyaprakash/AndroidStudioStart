package com.example.ad_first

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthMissingActivityForRecaptchaException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            AppNavigation()

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
            .addOnSuccessListener { task ->

                if (task.user != null) {
                    println("User Created")
                    var user = auth.currentUser
                    println(user?.uid)
                }
            }
    }

    var storedVerificationId: String? = null
    lateinit var resendToken: PhoneAuthProvider.ForceResendingToken
    val callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        override fun onVerificationCompleted(credential: PhoneAuthCredential) {
            Log.d(TAG, "onVerificationCompleted:$credential")
        }

        override fun onVerificationFailed(e: FirebaseException) {
            Log.w(TAG, "onVerificationFailed", e)

            if (e is FirebaseAuthInvalidCredentialsException) {
                // Invalid request
            } else if (e is FirebaseTooManyRequestsException) {
                // The SMS quota for the project has been exceeded
            } else if (e is FirebaseAuthMissingActivityForRecaptchaException) {
                // reCAPTCHA verification attempted with null Activity
            }

        }

        override fun onCodeSent(
            verificationId: String,
            token: PhoneAuthProvider.ForceResendingToken,
        ) {
            Log.d(TAG, "onCodeSent:$verificationId")

            // Save verification ID and resending token so we can use them later
            storedVerificationId = verificationId
            resendToken = token
        }
    }

    private fun startPhoneNumberVerification(phoneNumber: String) {
        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(phoneNumber) // Phone number to verify
            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
            .setActivity(this) // Activity (for callback binding)
            .setCallbacks(callbacks) // OnVerificationStateChangedCallbacks
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    private fun verifyOTP(otp: String) {
        val credential = PhoneAuthProvider.getCredential(storedVerificationId!!, otp)
        signInWithPhoneAuthCredential(credential)
    }

    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithCredential:success")

                    val user = task.result?.user
                } else {
                    // Sign in failed, display a message and update the UI
                    Log.w(TAG, "signInWithCredential:failure", task.exception)
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
                        // The verification code entered was invalid
                    }
                    // Update UI
                }
            }
    }

    @Composable
    fun LoginScreen(navController: NavHostController) {
        val phoneNumber = remember {
            mutableStateOf("")
        }
        val otp = remember {
            mutableStateOf("")
        }
        Scaffold { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(50.dp)
            ) {
                Card(
                    modifier = Modifier
                        .height(300.dp)
                        .width(700.dp)
                ) {
                    Column(modifier = Modifier.padding(10.dp)) {
                        OutlinedTextField(
                            value = phoneNumber.value,
                            onValueChange = { phoneNumber.value = it },
                            label = { Text(text = "Phone Number") },
                            modifier = Modifier
                                .fillMaxWidth()
                            //.clip(CircleShape)
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(onClick = {
                            startPhoneNumberVerification(phoneNumber.value)
                        }) {
                            Text(text = "Send OTP")
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        OutlinedTextField(
                            value = otp.value,
                            onValueChange = { otp.value = it },
                            label = { Text(text = "Enter Otp") },
                            modifier = Modifier
                                .fillMaxWidth()
                            //  .clip(CircleShape)
                        )

                        Spacer(modifier = Modifier.height(16.dp))
                        Button(onClick = { verifyOTP(otp.value) } ,
                            Modifier.fillMaxWidth()

                        ) {
                            Text(text = "Validate OTP")
                        }
                    }
                }

                Spacer(modifier = Modifier .height(20.dp))
                Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                    Button(onClick = { navController.navigate("ScaffoldExample") }) {
                        Text(text = "Sign In")
                    }
                }
            }
        }
    }

    @Composable
    fun card(navController: NavHostController) {
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
                Box(
                    modifier = Modifier
                        .background(colorResource(id = R.color.Green3))
                ) {
                    Column {
                        Text(
                            text = " Register ",
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxWidth(),
                            color = colorResource(id = R.color.teal_700),
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 30.sp,
                            textAlign = TextAlign.Center,
                        )
                        Column(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                        }
                        Text(
                            text = "Sign up ",
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
                                placeholder = { Text(text = "xyz@gmail.com") }
                            )
                            //Text(text)
                            Spacer(modifier = Modifier.height(20.dp))

                            OutlinedTextField(
                                value = password.value,
                                trailingIcon = {
                                    Icon(
                                        imageVector = Icons.Default.Lock,
                                        contentDescription = null
                                    )
                                },
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
                            fontWeight = FontWeight.W700,
                            color = colorResource(id = R.color.teal_700)
                        )

                       Row(Modifier
                           .padding(10.dp,2.dp),
                           horizontalArrangement = Arrangement.SpaceBetween) {
                           Button(onClick = {
                               signUp(email.value, password.value)
                           },
                               colors = ButtonDefaults.buttonColors(
                                   containerColor = colorResource(id = R.color.L_Blue)
                               ),
                               modifier = Modifier
                                   .padding(20.dp)
                                   .width(130.dp)
                                   .height(60.dp)

                           ) {
                               Text(text = "Sign Up", fontSize = 20.sp)
                           }

                           Button(onClick = {
                               signIn(email.value, password.value)
                           },
                               colors = ButtonDefaults.buttonColors(
                                   containerColor = colorResource(id = R.color.L_Blue)
                               ),
                               modifier = Modifier
                                   .padding(20.dp)
                                   .width(130.dp)
                                   .height(60.dp)

                           ) {
                               Text(text = "Sign In", fontSize = 20.sp)
                           }
                       }

                    }
                }
            }//Card End
            Spacer(modifier = Modifier.height(30.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "Don't have an account ? ", fontSize = 18.sp)
                Text(
                    text = " Register",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W700,
                    color = colorResource(
                        id = R.color.teal_700
                    )
                )
            }

        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ScaffoldExample(navController: NavHostController) {
        Scaffold(
            topBar = {
                TopAppBar(
                    colors = topAppBarColors(
                        containerColor = colorResource(id = R.color.teal_700),
                        titleContentColor = colorResource(id = R.color.Green3),
                    ),

                    title = {
                        Text(
                            "Jetpack",
                            textAlign = TextAlign.Center,
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                        )
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

            ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {

                //Start of task app

                Column(
                    modifier = Modifier
                        .padding(10.dp)
                ) {
                    card(navController)
                    Spacer(modifier = Modifier.height(20.dp))
                    Row(modifier = Modifier
                        .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically) {
                        
                        Button(onClick = { navController.navigate("LoginScreen") },
                                colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(id = R.color.L_Blue)
                                ),
                            modifier = Modifier
                                .padding(20.dp)
                                .width(130.dp)
                                .height(60.dp)
                        ) {
                            Text(text = "OTP" , fontSize = 20.sp)
                        }
                    }
                }


                //End of task app

            }
        }
    }

    @Composable
    fun Main(navController: NavHostController) {
        Column(
            Modifier
                .padding(20.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { navController.navigate("ScaffoldExample") }) {
                Text(text = "Sign In")
            }
            Button(onClick = { navController.navigate("LoginScreen") }) {
                Text(text = "OTP")
            }
        }
    }

    @Composable
    fun AppNavigation() {
        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = "Main"
        ) {
            composable("Main") { Main(navController) }

            composable("ScaffoldExample") { ScaffoldExample(navController) }
            /* composable("Screen4/{data}",
            arguments = listOf(navArgument("data") { type = NavType.StringType })
        ) { backStackEntry ->
            Screen4(navController, backStackEntry.arguments?.getString("data") ?: "")
        } */
            composable("LoginScreen") { LoginScreen(navController) }
        }
    }

}