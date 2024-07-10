package com.example.ad_first



//import retrofit.GsonConverterFactory
import android.media.Rating
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            val productVM: ProductVieModel by viewModels()
                Row(modifier=Modifier.background(Color.Black).fillMaxSize(),horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
                    Button(onClick = {productVM.fetchProducts()}) {
                        Text("Click to show data on logcat", color = Color.White)
                    }
                }
        }
    }
}
data class Product(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val category: String,
    val image: String,
    val rating: Rating
)
data class Rating(
    val rate: Double,
    val count: Int
)
interface ApiService{
    @GET("Products")
    suspend fun getProducts(): List<Product>
}
object RetrofitClient{
    private const val BASE_URL="https://fakestoreapi.com/"
    val apiService:ApiService by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
class ProductRepository(private val apiService: ApiService){
    suspend fun getProducts(): List<Product>{
        return apiService.getProducts()
    }
}
class ProductVieModel: ViewModel(){
    private val _products=MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>>get()= _products
    private val repository=ProductRepository(RetrofitClient.apiService)
    fun fetchProducts(){
        viewModelScope.launch {
            try {
                val productList=repository.getProducts()
                _products.postValue(productList)
                println("API DATA CALLED: $productList")
            }
            catch(e:Exception){
                println("Error: $e")
            }
        }
    }
}