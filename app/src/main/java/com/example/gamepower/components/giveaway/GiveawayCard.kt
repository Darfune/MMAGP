package com.example.gamepower.components.giveaway

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun GiveawayCard() {
    Card(
        modifier = Modifier.padding(4.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface,
            disabledContainerColor = MaterialTheme.colorScheme.surfaceVariant,
            disabledContentColor = MaterialTheme.colorScheme.onSurfaceVariant
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp,
            pressedElevation = 1.dp,
            focusedElevation = 1.dp,
            hoveredElevation = 1.dp,
            draggedElevation = 1.dp,
            disabledElevation = 0.dp
        ),
        border = null
    ) {
        CardContent(Modifier.padding(4.dp))
    }
}

@Composable
fun CardContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        GameTitle()
        GameImage()
        GameTags()
    }
}

@Composable
fun GameTags() {

}

@Composable
fun GameImage() {
    TODO("Not yet implemented")
}

@Composable
fun GameTitle() {
    Text(text = "Melvor Idle (Epic Games) Giveaway")
}
