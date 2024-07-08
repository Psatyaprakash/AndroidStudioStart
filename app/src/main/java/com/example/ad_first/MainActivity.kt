package com.example.ad_first

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            //Start()
            Second()
            //Third()


        }
    }
}




//Start Function
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Start(navController: NavController) {
    var presses by remember { mutableIntStateOf(0) }

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
            FloatingActionButton(onClick = { presses++ }) {
                Box(modifier = Modifier
                    .background(colorResource(id = R.color.Green3))
                    .size(60.dp) ,
                    Alignment.Center
                ){
                    Icon(Icons.Default.ArrowForward, contentDescription = "Add")
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
           /* Text(
                modifier = Modifier.padding(8.dp),
                text =
                """
                    This is an example of a scaffold. It uses the Scaffold composable's parameters to create a screen with a simple top app bar, bottom app bar, and floating action button.
                    It also contains some basic inner content, such as this text.
                    You have pressed the floating action button $presses times.
                """.trimIndent(),
            )
            */

            //Start of task app

            Column (
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Firstcard()
            }


            //End of task app


        }
    }
}
@Composable
fun Firstcard() {
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
                        Image(painter = painterResource(id = R.drawable.jetpackcompose),
                            contentDescription = "Jetpack Compose" ,
                            modifier = Modifier
                                .size(150.dp)
                                .fillMaxWidth(),
                            contentScale = ContentScale.Fit
                        )
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
                    var text by remember { mutableStateOf("") }

                    Column(
                        modifier = Modifier
                            .padding(20.dp)
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        OutlinedTextField(value = text,
                            onValueChange = { text = it },
                            label = {
                                Text(
                                    " Mobile no. ",
                                    fontSize = 20.sp
                                )
                            },
                            placeholder = { Text(text = "1234-567-890")},
                            //keyboardOptions = KeyboardType.Number
                        )
                        //Text(text)
                        Spacer(modifier = Modifier.height(20.dp))
                        var password by rememberSaveable { mutableStateOf("") }
                        var isClicked by remember { mutableStateOf(false) }
                        OutlinedTextField(
                            value = password,
                            trailingIcon = { Icon(imageVector = if(isClicked) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                                contentDescription = "Password" , modifier = Modifier .clickable { isClicked = !isClicked } ) } ,
                            visualTransformation = if (isClicked) VisualTransformation.None else PasswordVisualTransformation(),
                            onValueChange = {password = it },
                            label = { Text(text = "Password") },
                            placeholder = { Text(text = "Enter your Password") },
                        )

                    }/*
                    Spacer(modifier = Modifier.height(20.dp) )
                    Icon(Icons.Filled.Lock,
                        "Floating action button." ,
                        Modifier
                            .size(50.dp)
                            .fillMaxWidth(),
                        tint = colorResource(id = R.color.Green2)) */

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

                    Button(onClick = { println("Login") } ,
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
//Start function end


//Second page start
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Second() {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = colorResource(id = R.color.teal_700),
                    titleContentColor = colorResource(id = R.color.Green3),
                ),

                title = {
                    Text("Jetpack Lists",
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
                    text = "Feeling Awesome",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    //color = colorResource(id = R.color.teal_700)
                )
            }
        },

        floatingActionButton = {
            Row (modifier = Modifier
                .width(430.dp)
                .padding(20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
                ){
                FloatingActionButton(onClick = {  } ) {
                    Box(modifier = Modifier
                        .background(colorResource(id = R.color.Green3))
                        .size(60.dp) ,
                        Alignment.Center
                    ){
                        Icon(Icons.Default.ArrowBack, contentDescription = "Prev")
                    }
                }
                FloatingActionButton(onClick = {  }) {
                    Box(modifier = Modifier
                        .background(colorResource(id = R.color.Green3))
                        .size(60.dp) ,
                        Alignment.Center
                    ){
                        Icon(Icons.Default.ArrowForward, contentDescription = "Next")
                    }
                }
            }

        }


    ) {
            innerPadding ->
        val sheetState = rememberModalBottomSheetState()
        var showBottomSheet by remember {
            mutableStateOf(false)
        }
        var showAlert by remember {
            mutableStateOf(false)
        }
        Column(modifier = Modifier.padding(innerPadding)) {

            var itemsList = List(5) { "Shopping item : ${it + 1}" }
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "List", fontSize = 40.sp, fontWeight = FontWeight.Bold)
                LazyColumn(
                    modifier = Modifier
                        .height(200.dp)
                        .width(200.dp)
                        .padding(5.dp)
                        .border(2.dp, Color.Black),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    items(itemsList) { item ->
                        Text(
                            text = item,
                            modifier = Modifier.padding(4.dp)
                        )
                    }
                }

                //Spacer(modifier = Modifier .height(30.dp))
                Text( text = "This is a list of top 30 Universities of India" , fontSize = 30.sp, textAlign = TextAlign.Center )

                var lazylist = List(30) { "Indian Universities : ${it + 1}"}
                LazyColumn (
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp)
                        .padding(5.dp)
                        .border(2.dp, Color.Black),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    items(lazylist){
                        item ->
                        Text(text = item , fontSize = 20.sp)
                    }
                }

               /* Button(onClick = { showBottomSheet = true }) {
                    Text(text = "Show Bottom Sheet")
                }
                Button(onClick = { showAlert = true }) {
                    Text(text = "Show Alert")
                } */
            }
        }

        if (showAlert) {
            AlertDialogExample()
        }
        if(showBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = { showBottomSheet = false },
                sheetState = sheetState,
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Column(modifier  = Modifier
                    .padding(10.dp)
                    .fillMaxSize()) {
                    Text(text ="Hello Am Bottom Sheet")

                }
            }
        }
    }
}

@Composable
fun AlertDialogExample() {

    AlertDialog(
        icon = { Icon(Icons.Filled.Done, contentDescription = "Done") },

        title = {
            Text(text = "Emergency")
        },
        text = {
            Text(text = "Jetpack Compose is updating it's libraries with more UI elements")
        },
        onDismissRequest =  { },
        confirmButton = { TextButton(onClick = { }) {
            Text(text = "Alright")
        } }
    )
}
//Second Page end

//Third page start
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Third() {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = colorResource(id = R.color.teal_700),
                    titleContentColor = colorResource(id = R.color.Green3),
                ),

                title = {
                    Text("Jetpack Grids",
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
                    text = "Hydrated and Motivated",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    //color = colorResource(id = R.color.teal_700)
                )
            }
        },

        floatingActionButton = {
            Row (modifier = Modifier
                .width(430.dp)
                .padding(20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                FloatingActionButton(onClick = {  } ) {
                    Box(modifier = Modifier
                        .background(colorResource(id = R.color.Green3))
                        .size(60.dp) ,
                        Alignment.Center
                    ){
                        Icon(Icons.Default.ArrowBack, contentDescription = "Prev")
                    }
                }
                FloatingActionButton(onClick = {  }) {
                    Box(modifier = Modifier
                        .background(colorResource(id = R.color.Green3))
                        .size(60.dp) ,
                        Alignment.Center
                    ){
                        Icon(Icons.Default.ArrowForward, contentDescription = "Next")
                    }
                }
            }

        }


    ) {
        innerPadding ->

        val newlist = List(100) {"Uploaded : ${it + 1}"}
        Column (
            Modifier
                .padding(innerPadding)
                .background(Color.LightGray)
        ){
            LazyVerticalGrid( columns = GridCells.Adaptive( 120.dp) ) {
                items(newlist) {
                    Card(
                        Modifier
                            .height(200.dp)
                            .fillMaxWidth()
                            .padding(10.dp),

                    ) {
                        Column(modifier = Modifier
                            .padding(5.dp)
                            .fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceEvenly)
                        {

                                Text(text = it)
                                Text(text = "Drive")
                            Image(painter = painterResource(id = R.drawable.flower),
                                contentDescription = "" ,
                                Modifier .size(120.dp) )
                        }
                    }

                }
            }
        }



    }
}

//Third page end