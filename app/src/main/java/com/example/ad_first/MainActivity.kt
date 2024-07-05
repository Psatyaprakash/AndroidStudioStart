package com.example.ad_first

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Magenta
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ad_first.ui.theme.Purple40
import com.example.ad_first.ui.theme.Purple80
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            val Pink40 = Color(0xFF7D5260)
            Column (
                modifier = Modifier
                    .background(Black),
                verticalArrangement =  Arrangement.spacedBy(30.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

//            First()
//            Second()
//            Third()
//            Fourth()
//            Fifth ()
//            Grad()
                AlignTry1()
                Greeting(name = "Prakash")
                //Button(onClick = println("Hello")) {}
               Text(text = "--------------------" , color = Magenta , fontSize = 40.sp)
                AlignTry2()
            }

        }
    }
}

@Composable
fun  First() {
               val rainbowColors=listOf(Red,Cyan,Blue,Green, Yellow)

               Text(
                   modifier = Modifier
                       .background(Magenta ),
                   text = buildAnnotatedString {
                       append("\nDo not allow people to dim your shine\n")
                       withStyle(
                           SpanStyle(
                               brush = Brush.linearGradient(
                                   colors = rainbowColors
                               ), alpha = 1f
                           )
                       ) {
                           append("because they are blinded.\t")
                       }
                       withStyle(
                           SpanStyle(
                               brush=Brush.linearGradient(
                                   colors=rainbowColors
                               ), alpha= 1f
                           )
                       ) {
                           append("Tell them to put some sunglasses on.")
                       }
                   }
               )
           }
@Composable
fun Second() {
    Text(
        buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color.Blue,fontSize = 30.sp,)) {
                append("H")
            }
            append("ello ")

            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Red, fontSize = 30.sp,)) {
                append("W")
            }
            append("orld")
        }
    )
}

@Composable
fun Third() {
    val gradientColors = listOf(Cyan, Blue, Red )
    Text(
        text = "Hello Everyone This Is A Gradient Text",
        fontSize = 50. sp,
        style = androidx.compose.ui.text.TextStyle(
            brush = Brush.linearGradient(
                colors = gradientColors
            )
        )
    )
}

@Composable
fun Fourth() {
    Text(

        text = buildAnnotatedString {
            append("\nDo not allow people to dim your shine\n")
            val rainbowColors = listOf(Red, Blue, Green)
            withStyle(
                SpanStyle(
                    brush = Brush.linearGradient(
                        colors = rainbowColors
                    )
                )
            ) {
                append("because they are blinded.")
            }
            append("\nTell them to put some sunglasses on.")
        }
    )
}

@Composable
fun Fifth () {
    {
        val rainbowColors = listOf(Red, Blue, Green)
        val brush = Brush.linearGradient(colors = rainbowColors)
        buildAnnotatedString {
            withStyle(
                SpanStyle(
                    brush = brush , alpha = .6f
                )
            ) {
                append("Text in ")
            }
            withStyle(
                SpanStyle(
                    brush = brush, alpha = 1f
                )
            ) {
                append("Compose ❤️")
            }
        }
    }
}

@Composable
fun Grad() {
    Text(
        buildAnnotatedString {
            append("\n")
            withStyle(style = androidx.compose.ui.text.ParagraphStyle(lineHeight = 30.sp)) {
                withStyle(style = SpanStyle(color = Color.Blue, fontSize = 30.sp)) {
                    append("Hello\n")
                }
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold, color = Color.Red, fontSize = 30.sp
                    )
                ) {
                    append("World\n")
                }
                withStyle(
                    style = SpanStyle(fontSize = 30.sp)
                ){ append("Compose") }

            }
        }
    )
}

@Composable
fun AlignTry1() {
    val LightBlue = Color(0xFF0066FF)
    val Purple = Color(0xFF800080)

    val rainbowColors = listOf(Red, Blue, Green)
    val brush = Brush.linearGradient(colors = rainbowColors)
    Column (
        modifier = Modifier
            .background(Black)
            .fillMaxWidth()
            .padding(20.dp),
        verticalArrangement =  Arrangement.spacedBy(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text("1.Hello World ", fontSize = 30.sp, color = Magenta)
        Text("2.First program", fontSize = 30.sp, color = Magenta)
        Row (
            modifier = Modifier
                .background(Purple40)
                .fillMaxWidth()
                .padding(10.dp)
                .height(30.dp),
                verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "New Row ", fontWeight = FontWeight.ExtraBold , fontSize = 20.sp, color = Cyan)
            Text(text = "| Row two ", fontWeight = FontWeight.ExtraBold , fontSize = 20.sp, color = Green)
            Text(text = "| Row Three ", fontWeight = FontWeight.ExtraBold , fontSize = 20.sp, color = Yellow)
            Text(text = "| Row Four ", fontWeight = FontWeight.ExtraBold , fontSize = 20.sp, color = Red)

        }
    }
}
@Composable
private fun Greeting(name: String) {
    Row(
        modifier = Modifier
            .padding(24.dp)
            .background(White)
            .fillMaxWidth()
            .size(100.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text = "Hello ", fontWeight = FontWeight.ExtraBold ,fontSize = 50.sp)
        Text(text = name , fontWeight = FontWeight.ExtraBold ,fontSize = 50.sp)
    }
}

@Composable
fun AlignTry2() {
    Text(
        text = "Feeling so awesome !!! 😎😎 ",
        color = Purple80,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Italic,
        fontSize = 40.sp
    )
}

/*
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AD_FirstTheme {
        Greeting("Android")
    }
}*/