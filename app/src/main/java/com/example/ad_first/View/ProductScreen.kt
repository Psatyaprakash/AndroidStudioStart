package com.example.ad_first.View

//import com.example.ad_first.Model.Data.Product
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.ad_first.Model.Data.Restaurant
import com.example.ad_first.ViewModel.ProductViewModel


@Composable
fun ProductScreen(productVM : ProductViewModel){
    val restuarants by productVM.restaurants.observeAsState(emptyList())
    LazyColumn {
        items(restuarants){
            RestuarantItem(product = it)
        }
    }
}




/*
@Composable
fun ProductItem(product: Product){
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "${product.id}" )
        Spacer(modifier = Modifier .height(10.dp))
        Text(text = ("\nRating : ${product.rating.rate
        }"))
    }
}
*/

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestuarantItem(product: Restaurant){
    ElevatedCard(
        Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .height(200.dp)
            .shadow(15.dp),

    ){
        Box(modifier = Modifier
            //.background(colorResource(id = R.color.Heavy))
            .fillMaxSize(),

        )
        {
            Row(modifier = Modifier
                .background(Color.White)
//                horizontalArrangement = Arrangement.Center
                .matchParentSize(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Box(modifier = Modifier
                    .fillMaxWidth(0.3f)
                    .height(200.dp)
                    .padding(5.dp, 20.dp),
                    Alignment.Center
                ){
                    AsyncImage(
                        model = product.menu.items.images,
                        contentDescription = null,
                        //contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .padding(10.dp)
                            .background(Color.White),
                    )

                }
//                Spacer(modifier = Modifier .width(5.dp) )
                Text(text = product.name)
               /* Column(
                    modifier = Modifier
                        .padding(5.dp, 0.dp, 0.dp, 0.dp)
                        //.background(Color.Cyan)
                        .height(200.dp),
                    verticalArrangement = Arrangement.Center

                ){
                    Text(text = ("Category : ${product.category}") ,
                        textAlign = TextAlign.Start,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(4.dp),
                        fontWeight = FontWeight.W900,
                        fontSize = 20.sp
                    )
                    /*Text(text = ("Id : ${product.id}"),
                        textAlign = TextAlign.Start,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp),
                        fontWeight = FontWeight.W900,
                        fontSize = 20.sp
                    )*/
                    Text(
                        text = product.title, textAlign = TextAlign.Start,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp, 1.dp)
                    )
                    Row (verticalAlignment = Alignment.CenterVertically){
                        Text(text = "Rating : " ,
                            textAlign = TextAlign.Justify,
                            modifier = Modifier
                                //.fillMaxWidth()
                                .padding(5.dp),
                            fontWeight = FontWeight.W900,
                            fontSize = 15.sp
                        )
                        var _star = product.rating.rate

                        if(_star == _star.toInt().toDouble()){
                            _star -= 1
                        }

                        while (_star.toInt() !=0) {
                            Icon(
                                Icons.Default.Star,
                                contentDescription = "Star Filled",
                                modifier = Modifier
                                    .size(15.dp),
                            )
                            _star -= 1
                        }
                        _star = product.rating.rate
                        while ( (6 - _star).toInt() !=  0){
                            Icon(
                                Icons.Default.StarBorder,
                                contentDescription = "Star Filled",
                                modifier = Modifier
                                    .size(15.dp),
                            )
                            _star += 1
                        }
                        Text(text = "\t(${product.rating.count})" , fontWeight = FontWeight.W500, fontSize = 13.sp)

                    }
                    Text(
                        text = "Price : Rs. ${product.price}",
                        textAlign = TextAlign.Justify,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp),
                        fontWeight = FontWeight.W900,
                        fontSize = 20.sp
                    )

                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(1.dp, 15.dp, 20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Button(onClick = {   } ,
                            Modifier
                                .padding(5.dp, 0.dp)
                                .height(35.dp),
                            colors =  ButtonDefaults.buttonColors(Color.Black)
                        ) {
                            Text(text = "Buy Now")
                        }
                        Button(onClick = {  } ,
                            Modifier
                                .padding(5.dp, 0.dp)
                                .height(35.dp),
                            colors =  ButtonDefaults.buttonColors(Color.Black)){
                            Icon(
                                Icons.Default.AddShoppingCart, contentDescription = "Add To Cart",
                                Modifier
                                    .size(22.dp)
                            )
                            Text(text = "Add to cart")
                        }
                    }
                }

                */
            }
         /*   Badge(
                Modifier
                    .size(30.dp)
                    .align(Alignment.TopStart),
                containerColor =  colorResource(id = R.color.Heavy),

                ){
                Text(text = "M", color = Color.White, fontWeight = FontWeight.W900)
            }*/

        }
    }
}

