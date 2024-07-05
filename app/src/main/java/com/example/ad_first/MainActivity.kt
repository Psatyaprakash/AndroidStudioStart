package com.example.ad_first

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.ad_first.ui.theme.Purple40
import com.example.ad_first.ui.theme.Purple80


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            val Pink40 = Color(0xFF7D5260)
            val teal = colorResource(R.color.teal_700)
            Column (
                modifier = Modifier
                    .background(colorResource(R.color.teal_700))
                    .fillMaxSize()
                    .padding(30.dp),
                verticalArrangement =  Arrangement.spacedBy(30.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {/*
                //Day 7
            First()
            Second()
            Third()
            Fourth()
            Fifth ()
            Grad()
                CenterText()
                ParagraphStyle()
                lineheight(text = "This is a separate line text with increased line height")

                //Day 8

                AlignTry1()
                Greeting(name = "Prakash")
                Text(text = "--------------------" , color = Magenta , fontSize = 40.sp)
                AlignTry2()

                //Day 9
                Filled(onClick = { println("Filled is clicked") })
                FilledTonal(onClick = { println("FilledTonal is clicked") })
                Row(modifier = Modifier
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Outlined(onClick = { println("Outlined is clicked") })
                    Elevated(onClick = { println("Elevated is clicked") })
                }
                TxtButton(onClick = { println("TextButton is clicked") })
                Row(
                    modifier = Modifier
                        .padding(30.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Fab(onClick = { println("Fab is clicked") })
                    Home(onClick = { println("Home") })
                    Shop(onClick = { println("Shop is clicked") })
                }
                CardStart()
                FilledCard()
                OutlinedCard()

                AssistChip()
                FilterChip()
                InputChip("Input Chip" ){ Log.d("Input chip", "Chip dismissed") }

                SliderMinimal()
                SwitchMinimal()
                IndeterminateCircularIndicator() */

                Text("Column with divider", fontWeight = FontWeight.Bold)
                HorizontalDividerExample()
                Text("Row with divider", fontWeight = FontWeight.Bold)
                VerticalDividerExample()

            }
        }
    }
}

@Composable
fun HorizontalDividerExample() {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Text("First item in list")
        HorizontalDivider(thickness = 2.dp)
        Text("Second item in list")
    }
}
@Composable
fun VerticalDividerExample() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text("First item in row")
        VerticalDivider(color = MaterialTheme.colorScheme.primary)
        Text("Second item in row")
    }
}



@Preview
@Composable
fun SliderMinimal() {
    var sliderPosition by remember { mutableFloatStateOf(0f) }
    Column {
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it }
        )
        Text(text = sliderPosition.toString() , color = White , fontSize = 23.sp)
    }
}
@Composable
fun SwitchMinimal() {
    var checked by remember { mutableStateOf(true) }
    Switch(
        checked = checked,
        onCheckedChange = {
            checked = it
        }
    )
    Text(text = checked.toString() , color = White , fontSize = 20.sp)
}
@Composable
fun IndeterminateCircularIndicator() {
    var loading by remember { mutableStateOf(false) }

    Button(onClick = { loading = true }, enabled = !loading) {
        Text("Start loading" , color = Cyan, fontSize = 30.sp )
    }
    if (!loading) return
    CircularProgressIndicator(
        modifier = Modifier.width(64.dp),
        color = MaterialTheme.colorScheme.primary,
        trackColor = MaterialTheme.colorScheme.onTertiary,
    )
}

@Composable
fun AssistChip() {
    AssistChip(
        onClick = { Log.d("Assist chip", " hello world") },
        label = { Text("Assist chip") },
        leadingIcon = {
            Icon(
                Icons.Filled.Settings,
                contentDescription = "Localized description",
                Modifier.size(AssistChipDefaults.IconSize)
            )
        }
    )
}
@Composable
fun FilterChip() {
    var selected by remember { mutableStateOf(false) }

    FilterChip(
        onClick = { selected = !selected },
        label = {
            Text("Filter chip")
        },
        selected = selected,
        leadingIcon = if (selected) {
            {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Done icon",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        } else {
            null
        },
    )
}
@Composable
fun InputChip( text: String, onDismiss: () -> Unit,) {
    var enabled by remember { mutableStateOf(true) }
    if (!enabled) return

    InputChip(
        onClick = {
            onDismiss()
            enabled = !enabled
        },
        label = { Text(text) },
        selected = enabled,
        avatar = {
            Icon(
                Icons.Filled.Person,
                contentDescription = "Localized description",
                Modifier.size(InputChipDefaults.AvatarSize)
            )
        },
        trailingIcon = {
            Icon(
                Icons.Default.Close,
                contentDescription = "Localized description",
                Modifier.size(InputChipDefaults.AvatarSize)
            )
        },
    )
}


@Composable
fun CardStart() {
    Card(
        modifier = Modifier
            .padding(30.dp)
            .size(200.dp),

        shape = RoundedCornerShape(10.dp)
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(170.dp)
            .background(Purple40)
            .padding(10.dp) )
        Text(text = "Inserted new card ",
            fontSize = 20.sp ,
            fontWeight = FontWeight.W900 ,
            textAlign = TextAlign.Center,
            lineHeight = 15.sp
        )
    }
}
@Composable
fun FilledCard() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        modifier = Modifier
            .size(width = 240.dp, height = 100.dp)
    ) {

        Text(
            text = "Filled",
            modifier = Modifier
                .padding(30.dp),
            textAlign = TextAlign.Center,
            fontSize = 25.sp
        )
    }
}
@Composable
fun OutlinedCard() {
    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        border = BorderStroke(8.dp, Black),
        modifier = Modifier
            .size(width = 240.dp, height = 400.dp)
    ) {
        Text(
            text = "Outlined",
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Center,
            fontSize = 30.sp
        )
        Text(text = "   This is an outlined card")
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
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

//@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Greeting("Android")
}
@Composable
fun CenterText() {
    Text("Center Text", textAlign = TextAlign.Center, modifier = Modifier.width(100.dp) )
    Text("Limited width for text to flow ", textAlign = TextAlign.Center, modifier = Modifier.width(100.dp) )
}
@Composable
fun ParagraphStyle() {
    Text(
        buildAnnotatedString {
            withStyle(style = androidx.compose.ui.text.ParagraphStyle(lineHeight = 20.sp)) {
                withStyle(style = SpanStyle(color = Color.Blue)) {
                    append("Hello\n")
                }
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold, color = Color.Red
                    )
                ) {
                    append("World\n")
                }
                append("Compose")
            }
        }
    )
}
@Composable
fun lineheight(text : String){
    Text (
        text = (text), fontSize = 30.sp , modifier = Modifier
            .background(White)
            .padding(20.dp),
        style = LocalTextStyle.current.merge(
            TextStyle(lineHeight = 1.2.em, platformStyle = PlatformTextStyle(includeFontPadding = false),
                lineHeightStyle = LineHeightStyle(
                    alignment = LineHeightStyle.Alignment.Center,
                    trim = LineHeightStyle.Trim.FirstLineTop
                )
            )
        )
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


@Composable
fun Filled(onClick: () -> Unit) {
    Button(onClick = { onClick() } ) {
        Text("Filled")
    }
}
@Composable
fun FilledTonal(onClick: () -> Unit) {
    FilledTonalButton(onClick = { onClick() },
        modifier = Modifier
            .width(150.dp)

    ) {
        Text("Tonal" , fontSize = 20.sp , fontWeight = FontWeight.ExtraBold)
    }
}

@Composable
fun Outlined(onClick: () -> Unit) {
    OutlinedButton(onClick = { onClick() },
        modifier = Modifier
            .width(180.dp)

    )  {
        Text("Outlined", color = Cyan , fontSize = 30.sp , fontWeight = FontWeight.ExtraBold)
    }
}

@Composable
fun Elevated( onClick: () -> Unit ){
    ElevatedButton(onClick = { onClick() },
        modifier = Modifier
            .width(190.dp)
            .height(50.dp)
    ) {
        Text(text = "Elevated", fontSize = 30.sp , fontWeight = FontWeight.ExtraBold)
    }
}
@Composable
fun TxtButton( onClick: () -> Unit ) {
    TextButton( onClick = { onClick() } ) {
        Text(text = "Text Button" , fontSize = 30.sp , fontWeight = FontWeight.ExtraBold, color = Magenta )
    }
}
@Composable
fun Fab(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = { onClick() },
        modifier = Modifier
            .size(50.dp)
    ) {
        Icon(Icons.Filled.Add,
            "Floating action button.", Modifier.size(80.dp))
    }
}
@Composable
fun Shop(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = { onClick() },
        shape = CircleShape,
        modifier = Modifier
            .size(80.dp),
        //backgroundColor = colorResource(id = R.color.Green1)

    ) {
        Icon(Icons.Filled.ShoppingCart,
            "Floating action button." ,
            Modifier
                .size(50.dp)
                .fillMaxSize(),
            tint = colorResource(id = R.color.Green2))
    }
}
@Composable
fun Home( onClick:() -> Unit ) {
    FloatingActionButton(onClick = { onClick() } ,
        //shape = RectangleShape,
        shape = RoundedCornerShape(14.dp,),
        modifier = Modifier
            .height(80.dp)
            .width(180.dp)

    ) {
        Row(
            Modifier
                .background(colorResource(id = R.color.Green1))
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(Icons.Filled.Home,
                "Floating action button." ,
                modifier = Modifier .size(50.dp)
            )
            Text(text = " Home", fontSize = 30.sp
                , fontWeight = FontWeight.ExtraBold
                , color = colorResource(id = R.color.Blue1) )
        }
    }
}