package com.example.gamepower.ui.theme

import android.annotation.SuppressLint
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class RarityIconColors(
    val uncommon: Color = Color.Unspecified,
    val rare: Color = Color.Unspecified,
    val epic: Color = Color.Unspecified,
    val legendary: Color = Color.Unspecified,
)

val LightRarityIconColors = RarityIconColors(
    uncommon = light_Uncommon,
    rare = light_Rare,
    epic = light_Epic,
    legendary = light_Legendary,
)


val DarkRarityIconColors = RarityIconColors(
    uncommon = dark_Uncommon,
    rare = dark_Rare,
    epic = dark_Epic,
    legendary = dark_Legendary,
)

@SuppressLint("CompositionLocalNaming")
val IconColorPalette = staticCompositionLocalOf { RarityIconColors() }