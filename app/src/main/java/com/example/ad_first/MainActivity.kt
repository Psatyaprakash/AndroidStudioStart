package com.example.ad_first



//import retrofit.GsonConverterFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.ExperimentalMaterial3Api
import com.example.ad_first.View.MainScreen
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


