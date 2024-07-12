package com.example.ad_first



//import retrofit.GsonConverterFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.ShoppingBasket
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ad_first.View.ProductScreen
import com.example.ad_first.ViewModel.ProductViewModel


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {

                val productVM: ProductViewModel by viewModels()
                MainScreen(productVM)

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(productVM : ProductViewModel){
    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = colorResource(id = R.color.bgBlue),
                    titleContentColor = MaterialTheme.colorScheme.onSurfaceVariant,
                ),
                title = {
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp, 0.dp, 20.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Icon(Icons.Default.ArrowBackIosNew, contentDescription = "back")
                        Text("Prokart",
                            fontWeight = FontWeight.W900,
                            fontSize = 30.sp,
                            color = Color.Black
                        )
                        Icon(
                            Icons.Default.Search,
                            contentDescription = "search" ,
                            Modifier
                                .size(30.dp)

                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = colorResource(id = R.color.bgBlue),
                contentColor = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier
                    .height(70.dp)
            ) {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp, 0.dp, 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Icon(Icons.Default.Home, contentDescription = "")
                        Text(text = "Home", fontWeight = FontWeight.ExtraBold, fontSize = 15.sp)
                    }
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Icon(
                            Icons.Default.ShoppingCart, contentDescription = "" ,
                            Modifier.size(40.dp),
                            tint = colorResource(id = R.color.Heavy  )
                        )
                        Text(text = "Shop", fontWeight = FontWeight.ExtraBold, fontSize = 15.sp)
                    }
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Icon(Icons.Default.ShoppingBag, contentDescription = "" )
                        Text(text = "Bag", fontWeight = FontWeight.ExtraBold, fontSize = 15.sp)
                    }
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Icon(Icons.Default.ShoppingBasket, contentDescription = "" )
                        Text(text = "Fav", fontWeight = FontWeight.ExtraBold, fontSize = 15.sp)
                    }
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Icon(Icons.Default.Person, contentDescription = "" )
                        Text(text = "Profile", fontWeight = FontWeight.ExtraBold, fontSize = 15.sp)
                    }


                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { } ) {
                Box(modifier = Modifier
                    .background(colorResource(id = R.color.bgBlue))
                    .size(60.dp),
                    Alignment.Center
                ){
                    Icon(
                        Icons.Default.Call,
                        contentDescription = "Cart",
                        tint = Color.Black
                    )
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .background(colorResource(id = R.color.bgBlue)),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Column {
                Text(text = "Categories",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp, 0.dp),
                    textAlign = TextAlign.Start,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.W700
                )
                Row(
                    Modifier
                        .padding(10.dp, 10.dp,0.dp,0.dp)
                        .horizontalScroll(rememberScrollState())
                ){
                    Button(onClick = {}, Modifier.padding(2.dp,0.dp),
                        colors =  ButtonDefaults.buttonColors(Color.Black) ) {
                        Text(text = "Men's Wear")
                    }
                    Button(onClick = {}, Modifier.padding(2.dp,0.dp) ,
                        colors =  ButtonDefaults.buttonColors(Color.Black)) {
                        Text(text = "Women's Wear")
                    }
                    Button(onClick = {}, Modifier.padding(2.dp,0.dp) ,
                        colors =  ButtonDefaults.buttonColors(Color.Black)
                    ) {
                        Text(text = "Jewellery")
                    }
                    Button(onClick = {}, Modifier.padding(5.dp,0.dp) ,
                        colors =  ButtonDefaults.buttonColors(Color.Black)) {
                        Text(text = "Electronics")
                    }
                    Button(onClick = {}, Modifier.padding(5.dp,0.dp) ,
                        colors =  ButtonDefaults.buttonColors(Color.Black)) {
                        Text(text = "Accessories")
                    }
                    Button(onClick = {}, Modifier.padding(5.dp,0.dp) ,
                        colors =  ButtonDefaults.buttonColors(Color.Black)) {
                        Text(text = "Appliances")
                    }
                }
            }

            ProductScreen(productVM)

        }
    }
}


