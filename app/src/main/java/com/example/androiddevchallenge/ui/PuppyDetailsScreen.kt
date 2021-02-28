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
package com.example.androiddevchallenge.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Puppy
import com.example.androiddevchallenge.ui.theme.accentColor

@Composable
fun PuppyDetailsScreen(
    puppy: Puppy,
    navigateBack: () -> Unit
) {
    Scaffold(
        content = {
            PuppyDetailsContent(
                puppy = puppy,
                navigateBack = navigateBack
            )
        }
    )
}

@Composable
fun PuppyDetailsContent(puppy: Puppy, navigateBack: () -> Unit) {
    val scrollState = rememberScrollState()
    Column(
        Modifier.verticalScroll(scrollState)
    ) {
        val typography = MaterialTheme.typography
        PuppyHeader(imageRes = puppy.drawableRes, name = puppy.name, navigateBack = navigateBack)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = puppy.name, style = typography.h4, modifier = Modifier.padding(8.dp))
        Text(
            text = "Breed: ${puppy.breed}",
            style = typography.body1,
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = "Age: ${puppy.age}",
            style = typography.body1,
            modifier = Modifier.padding(8.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = { },
            modifier = Modifier.padding(16.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = accentColor)
        ) {
            Text(text = "Adopt Me")
        }
    }
}

@Composable
private fun PuppyHeader(
    @DrawableRes imageRes: Int,
    name: String,
    navigateBack: () -> Unit
) {
    Box(
        Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(imageRes),
            contentDescription = "Image of $name",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .aspectRatio(1f)
                .fillMaxWidth()
        )
        IconButton(onClick = navigateBack) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "back",
                tint = Color.White
            )
        }
    }
}
