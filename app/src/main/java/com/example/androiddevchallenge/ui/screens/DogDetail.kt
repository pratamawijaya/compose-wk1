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

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Female
import androidx.compose.material.icons.filled.Male
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.data.DogRepository
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun DogDetail(
    dogId: Int,
    onclick: () -> Unit
) {
    val dog = DogRepository.getDog(dogId)

    Column {
        CoilImage(
            data = dog?.img ?: "",
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
                text = dog?.name ?: "",
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
            Spacer(modifier = Modifier.padding(top = 8.dp))

            Row {
                val iconMale = Icons.Filled.Male
                val iconFemale = Icons.Filled.Female

                Text(text = "Gender  : ${dog?.gender}")
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    imageVector = if (dog!!.gender.toLowerCase() == "male"
                    ) iconMale else iconFemale,
                    contentDescription = "icons-gender"
                )
            }

            Spacer(modifier = Modifier.padding(top = 8.dp))

            Text(text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, ")

            Spacer(modifier = Modifier.padding(top = 8.dp))

            Button(
                onClick = {
//                Toast.makeText(co, "hello", Toast.LENGTH_SHORT).show()
                    Log.d("debug", "debug click ")
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Adopt Me")
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
