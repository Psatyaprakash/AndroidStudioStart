package com.example.ad_first


import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {

            Column(
                Modifier
                    .fillMaxSize()
                    .background(colorResource(id = R.color.Green2)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center

            ){
                Text(text = "MVVM architecture And Generics in Jetpack\n" ,
                    fontSize = 50.sp, textAlign = TextAlign.Center , )
                CounterView()
                val intContent = GenericClass(712)
                val stringContent = GenericClass("July")

                    Column(horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center){
                        Spacer(modifier=Modifier.height(10.dp))
                        Text("Integer value:${intContent.content}  ", fontSize = 20.sp)
                        Spacer(modifier = Modifier.height(10.dp))
                        Text("String:${stringContent.content}" , fontSize = 20.sp)
                        Spacer(modifier = Modifier .height(10.dp))
                        PrintContent(content =  "Its goin good" )
                    }

            }

        }
    }
}


//View MVVM
@Composable
fun CounterView(counterVM: CounterViewModel = viewModel()){
    val counterState=counterVM.counter.value
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){

        Text(text="Current Counter value: ${counterState.count}" , fontSize = 30.sp)
        Row{
            Button(onClick = {counterVM.increment()}){
                Text("Increment")
            }
            Spacer(modifier = Modifier.width(10.dp))
            Button(onClick = {counterVM.decrement()}){
                Text("Decrement")
            }
        }
        Button(onClick = {counterVM.resetValue()}){
            Text("Reset")
        }
    }
}
@Composable
fun<T> PrintContent(content: T){
    Text("Someone said ${content} Toh thik hai", fontSize = 20.sp)
}
data class Counter(val count:Int)
//data class User(val username:String, val password:String)

class CounterViewModel: ViewModel(){
    private val _counter= mutableStateOf(Counter(0))
    val counter: State<Counter> = _counter
    fun increment(){
        _counter.value = Counter(_counter.value.count+1)
    }
    fun decrement(){
        _counter.value=Counter(_counter.value.count -1)
    }
    fun resetValue(){
        _counter.value=Counter(0)
    }
}

class GenericClass<T>(var content: T)

