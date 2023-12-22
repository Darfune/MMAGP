package com.example.gamepower.components.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun UncommonIcon() {
    OutlinedCard(
        border = BorderStroke(1.dp, Color.Green), shape = RoundedCornerShape(6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Text(
            text = "Uncommon",
            color = Color.Green,
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
        )
    }
}

@Preview
@Composable
fun RareIcon() {
    OutlinedCard(
        border = BorderStroke(1.dp, Color.Cyan), shape = RoundedCornerShape(6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Text(
            text = "Rare",
            color = Color.Cyan,
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
        )
    }
}

@Preview
@Composable
fun EpicIcon() {
    OutlinedCard(
        border = BorderStroke(1.dp, Color.Magenta),
        shape = RoundedCornerShape(6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Text(
            text = "Epic",
            color = Color.Magenta,
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
        )
    }
}

@Preview
@Composable
fun LegendaryIcon() {
    OutlinedCard(
        border = BorderStroke(1.dp, Color.Yellow), shape = RoundedCornerShape(6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Text(
            text = "Legendary",
            color = Color.Yellow,
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
        )
    }
}

@Preview
@Composable
fun ExpiredIcon() {
    OutlinedCard(
        border = BorderStroke(1.dp, Color.Gray), shape = RoundedCornerShape(6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Text(
            text = "Expired",
            color = Color.Gray,
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
        )
    }
}

@Preview
@Composable
fun GiveawayType(type: String = "Beta Access") {
    Card(
        shape = RoundedCornerShape(6.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Gray,
            contentColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Text(
            text = type,
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
        )
    }
}

@Preview
@Composable
fun FreeTag(price: String? = "$2.99") {
    Row {
        OutlinedCard(
            border = BorderStroke(1.dp, Color.Gray), shape = RoundedCornerShape(6.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Transparent)
        ) {
            Text(
                text = "FREE",
                color = Color.Gray,
                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
            )
        }
        if (!price.isNullOrBlank())
            Text(
                text = price,
                modifier = Modifier.padding(start = 2.dp, top = 2.dp),
                style = TextStyle(textDecoration = TextDecoration.LineThrough)
            )
    }
}
