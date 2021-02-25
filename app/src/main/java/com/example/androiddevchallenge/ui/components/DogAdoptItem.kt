package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun DogAdoptItem(counter: Int = 1) {
    Column {
        Row(modifier = Modifier.padding(8.dp)) {
            CoilImage(
                data = "https://picsum.photos/200",
                contentDescription = "image of dog",
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(4.dp))
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp)
            ) {
                Text(text = "Available Dog $counter", fontWeight = FontWeight.Bold)
                Text(
                    text = "Gender : " + if (counter % 2 == 0) "Male" else "Female",
                    style = MaterialTheme.typography.subtitle1
                )
            }
        }
        Spacer(modifier = Modifier.height(2.dp))
        Divider(color = Color.Black)
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