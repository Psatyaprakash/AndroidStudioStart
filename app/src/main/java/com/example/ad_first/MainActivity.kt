package com.example.ad_first



//import retrofit.GsonConverterFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.ad_first.View.RestaurantScreen
import com.example.ad_first.ViewModel.RestaurantViewModel


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            val restaurantVM: RestaurantViewModel by viewModels()
            Surface(
                color = MaterialTheme.colorScheme.background
            ) {
                RestaurantScreen(restaurantVM)
            }
        }
    }
}


