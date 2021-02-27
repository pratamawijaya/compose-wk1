/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
import com.example.androiddevchallenge.data.DogRepository
import com.example.androiddevchallenge.model.Dog
import com.example.androiddevchallenge.ui.components.DogAdoptItem

@Composable
fun DogList(modifier: Modifier = Modifier, navController: NavController) {
    BodyContent(
        modifier = modifier
            .padding(8.dp),
        onClick = { dog ->
            navController.navigate(route = "detail/${dog.id}")
        },
    )
}

@Composable
fun ImageList(
    dogs: List<Dog>,
    scrollState: LazyListState,
    modifier: Modifier,
    onClick: (Dog) -> Unit
) {
    LazyColumn(modifier = modifier.fillMaxWidth(), state = scrollState) {
        items(dogs, key = { dog -> dog.id }) { dog ->
            DogAdoptItem(dog = dog, onClick = onClick)
        }
    }
}

@Composable
fun BodyContent(modifier: Modifier = Modifier, onClick: (Dog) -> Unit) {
    val dogs = DogRepository.generateDogs()
    val scrollState = rememberLazyListState()

    ImageList(dogs = dogs, scrollState = scrollState, modifier = modifier, onClick = onClick)
}
