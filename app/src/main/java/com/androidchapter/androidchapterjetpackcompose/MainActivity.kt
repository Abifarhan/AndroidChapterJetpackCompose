package com.androidchapter.androidchapterjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.androidchapter.androidchapterjetpackcompose.ui.theme.AndroidChapterJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidChapterJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CreateBizCard()
                }
            }
        }
    }
}

@Preview
@Composable
fun CreateBizCard() {

    val buttonClickedState = remember {
        mutableStateOf(false)
    }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {

        Card(modifier = Modifier
            .width(200.dp)
            .height(390.dp)
            .padding(12.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            elevation = 4.dp
        ) {
            Column(modifier = Modifier.height(300.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                CreateImageProfile()
                Divider()
                CreateInfo()
                Button(onClick = {
                    buttonClickedState.value = !buttonClickedState.value
                }) {
                    Text(text = "Portfolio")
                }

                if (buttonClickedState.value) {
                    Content()
                }
            }
        }
    }
}

@Preview
@Composable
fun Content() {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(5.dp)
    ){
        Surface(modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth()
            .fillMaxHeight(),

            shape = RoundedCornerShape(corner = CornerSize(
                6.dp
            )),
            border = BorderStroke(width = 2.dp, color = Color.LightGray)
        ) {

            PortFolio(data = listOf(
                "Tony Kroos",
                "Benzema",
                "Vinicius Jr"
            ))
        }
    }
}

@Composable
fun PortFolio(data: List<String>) {
    LazyColumn{
        items(data){ item ->
            Card(modifier = Modifier
                .padding(13.dp)
                .fillMaxWidth(),
                shape = RectangleShape,
                elevation = 4.dp
            ) {
                Row(modifier = Modifier
                    .padding(8.dp)
                    .background(MaterialTheme.colors.surface)
                    .padding(7.dp)
                ) {
                    CreateImageProfile(modifier = Modifier.size(100.dp))
                    Column(modifier = Modifier
                        .padding(7.dp)
                        .align(alignment = Alignment.CenterVertically)
                    ) {
                        Text(text = item, fontWeight = FontWeight.Bold)
                        Text(text = "Football Player", style = MaterialTheme.typography.body2)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun CreateInfo() {
    Column(modifier = Modifier.padding(5.dp)) {
        Text(text = "Luca Modric 123", style = MaterialTheme.typography.h4, color = MaterialTheme.colors.primaryVariant)
        Text(text = "Football Payer", modifier = Modifier.padding(3.dp))

        Text(text = "@lucamodric", modifier = Modifier.padding(3.dp), style = MaterialTheme.typography.subtitle1)

    }
}

@Preview
@Composable
fun CreateImageProfile(modifier: Modifier = Modifier) {
    androidx.compose.material.Surface(modifier = Modifier
        .size(150.dp)
        .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.Blue),
        elevation = 4.dp,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
    ) {

        Image(painter = painterResource(id = R.drawable.cat),
            contentDescription = "Cat Images",
            modifier = modifier.size(135.dp),
            contentScale = ContentScale.Crop

        )

    }
}

