package com.example.network.model.domain

import androidx.compose.ui.graphics.Color

sealed class WorthTag(val tag: String, val color: Color) {
    object Uncommon: WorthTag("Uncommon", Color.Green)
    object Rare: WorthTag("Rare", Color.Cyan)
    object Epic: WorthTag("Epic", Color.Magenta)
    object Legendary: WorthTag("Legendary", Color.Yellow)
}