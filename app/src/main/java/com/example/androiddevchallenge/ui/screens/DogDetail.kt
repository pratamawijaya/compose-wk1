package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun DogDetail(
    dogId: Int,
    dogName: String = "",
    dogImage: String = "",
    dogGender: String = "",
    onclick: () -> Unit
) {
    Column {
        CoilImage(
            data = "https://ggsc.s3.amazonaws.com/images/uploads/The_Science-Backed_Benefits_of_Being_a_Dog_Owner.jpg",
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
                text = "Dog Name",
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
            Button(onClick = { onclick }) {
                Text(text = "Adopt Me")
            }
        }
    }
}

@Preview
@Composable
fun PreviewDogDetail() {
    MyTheme {
        DogDetail(dogId = 1, onclick = {})
    }
}