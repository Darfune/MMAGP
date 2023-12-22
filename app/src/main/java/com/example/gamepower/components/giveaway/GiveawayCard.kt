package com.example.gamepower.components.giveaway

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import com.example.gamepower.components.common.EpicIcon
import com.example.gamepower.components.common.FreeTag
import com.example.gamepower.components.common.GiveawayType
import com.example.gamepower.components.common.LoadingState

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
        GameImage()
        GameTitle()
        GameTags()
    }
}

@Composable
fun GameTags() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        FreeTag()
        Row{
            GiveawayType()
            Spacer(modifier = Modifier.width(2.dp))
            EpicIcon()
        }
    }
}

@Composable
fun GameImage() {
    Box {
        Surface(
            shape = RoundedCornerShape(12.dp),
            tonalElevation = 12.dp
        ) {
            ExpirationData(Color.Gray)
            SubcomposeAsyncImage(
                model = "https://www.gamerpower.com/offers/1b/6584900c10ebe.jpg",
                contentDescription = "Game thumb",
                modifier = Modifier.fillMaxWidth(),
                loading = { LoadingState() }
            )
        }
    }
}

@Composable
fun ExpirationData(color: Color) {
    Surface(
        modifier = Modifier.padding(start = 4.dp, top = 4.dp),
        tonalElevation = 12.dp,
        color = color,
        shape = RoundedCornerShape(12.dp)
    ) {
        Text(
            text = "End in 13 days",
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
        )
    }
}

@Composable
fun GameTitle() {
    Text(text = "Melvor Idle (Epic Games) Giveaway")
}
