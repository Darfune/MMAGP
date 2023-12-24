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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@Composable
fun RarityIcon(rarity: String, color: Color) {
    OutlinedCard(
        border = BorderStroke(1.dp, color), shape = RoundedCornerShape(6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Text(
            text = rarity,
            color = color,
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
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
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun GiveawayType(type: String) {
    Card(
        shape = RoundedCornerShape(6.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Gray,
            contentColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Text(
            text = type,
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
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
                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
        if (!price.isNullOrBlank())
            Text(
                text = price,
                modifier = Modifier.padding(start = 2.dp, top = 2.dp),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                style = TextStyle(textDecoration = TextDecoration.LineThrough)
            )
    }
}
