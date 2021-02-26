package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.model.Dog
import com.example.androiddevchallenge.ui.components.DogAdoptItem

@Composable
fun DogList(modifier: Modifier = Modifier, navController: NavController) {
    BodyContent(
        modifier = modifier
            .padding(8.dp),
        onClick = { id ->
            navController.navigate(route = "detail/$id")
        }
    )
}

@Composable
fun ImageList(
    dogs: List<Dog>,
    scrollState: LazyListState,
    modifier: Modifier,
    onClick: (Int) -> Unit
) {
    LazyColumn(modifier = modifier.fillMaxWidth(), state = scrollState) {
        items(dogs, key = { dog -> dog.id }) { dog ->
            DogAdoptItem(dog = dog, onClick = onClick)
        }
    }
}

@Composable
fun BodyContent(modifier: Modifier = Modifier, onClick: (Int) -> Unit) {
    val dogs = mutableListOf(
        Dog(
            id = 1,
            name = "Dogo",
            gender = "Male",
            img = "https://ggsc.s3.amazonaws.com/images/uploads/The_Science-Backed_Benefits_of_Being_a_Dog_Owner.jpg"
        ),
        Dog(
            id = 2,
            name = "Json",
            gender = "Male",
            img = "https://i.insider.com/5484d9d1eab8ea3017b17e29?width=1100&format=jpeg&auto=webp"
        ),
        Dog(
            id = 3,
            name = "Pitt",
            gender = "Female",
            img = "https://img.webmd.com/dtmcms/live/webmd/consumer_assets/site_images/article_thumbnails/other/dog_cool_summer_slideshow/1800x1200_dog_cool_summer_other.jpg"
        ),
        Dog(
            id = 4,
            name = "Sparta",
            gender = "Male",
            img = "https://ggsc.s3.amazonaws.com/images/uploads/The_Science-Backed_Benefits_of_Being_a_Dog_Owner.jpg"
        ),
        Dog(
            id = 5,
            name = "Abigail",
            gender = "Female",
            img = "https://i.insider.com/5484d9d1eab8ea3017b17e29?width=1100&format=jpeg&auto=webp"
        ),
        Dog(
            id = 6,
            name = "Pitt",
            gender = "Female",
            img = "https://img.webmd.com/dtmcms/live/webmd/consumer_assets/site_images/article_thumbnails/other/dog_cool_summer_slideshow/1800x1200_dog_cool_summer_other.jpg"
        )

    )
    val scrollState = rememberLazyListState()

    ImageList(dogs = dogs, scrollState = scrollState, modifier = modifier, onClick = onClick)
}