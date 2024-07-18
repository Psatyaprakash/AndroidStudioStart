package com.example.ad_first.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ad_first.Model.API.RetrofitClient
import com.example.ad_first.Model.Data.Product
import com.example.ad_first.Model.Repository.ProductRepository
import kotlinx.coroutines.launch

class ProductViewModel: ViewModel(){
    private val _products= MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>>
        get()= _products
    private val repository= ProductRepository(RetrofitClient.apiService)

    init {
        fetchProducts()
    }

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