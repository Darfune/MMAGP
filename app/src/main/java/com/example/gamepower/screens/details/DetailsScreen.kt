package com.example.gamepower.screens.details

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.network.model.domain.giveaway.Giveaway

@Composable
fun DetailsScreen(description :String) {
    Column {
//        Text(text = giveaway.title)
        Text(text = description)
    }
}