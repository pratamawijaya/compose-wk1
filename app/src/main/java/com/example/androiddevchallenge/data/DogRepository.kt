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
package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.model.Dog

object DogRepository {
    private val dogs = listOf(
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
            img = "https://s3.amazonaws.com/cdn-origin-etr.akc.org/wp-content/uploads/2017/11/26155623/Siberian-Husky-standing-outdoors-in-the-winter.jpg"
        ),
        Dog(
            id = 5,
            name = "Abigail",
            gender = "Female",
            img = "https://www.thesprucepets.com/thmb/s0iMKXLtQj9Qo3tjnKBX1UKiNrI=/450x0/filters:no_upscale():max_bytes(150000):strip_icc()/GettyImages-518014900-e959b37191d54e7d969b28f4dfe51434.jpg"
        ),
        Dog(
            id = 6,
            name = "Pitt",
            gender = "Female",
            img = "https://www.thelabradorsite.com/wp-content/uploads/2017/09/Cute-Dog-Names-LS-long.jpg"
        )
    )

    fun generateDogs(): List<Dog> {
        return dogs
    }

    fun getDog(id: Int): Dog? {
        var dogs = dogs.filter { it.id == id }
        return if (dogs.isNotEmpty()) {
            dogs[0]
        } else {
            null
        }
    }
}
