package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun DogAdoptItem(modifier: Modifier = Modifier, counter: Int = 1) {
    Column(modifier = modifier
        .padding(bottom = 16.dp)
        .clickable { }) {
        CoilImage(
            data = "https://static.toiimg.com/thumb/msid-60132235,imgsize-169468,width-800,height-600,resizemode-75/60132235.jpg",
            contentDescription = "image of dog",
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .height(220.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )
        Column(modifier = Modifier.padding(8.dp)) {
            Text(
                text = "Available Dog $counter",
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
            Text(
                text = "Gender : " + if (counter % 2 == 0) "Male" else "Female",
                fontWeight = FontWeight.Light,
                fontSize = 14.sp
            )
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun DogLightPreview() {
    MyTheme {
        DogAdoptItem()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DogDarkPreview() {
    MyTheme(darkTheme = true) {
        DogAdoptItem()
    }
}