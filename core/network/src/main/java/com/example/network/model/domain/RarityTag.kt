package com.example.network.model.domain

import android.os.Parcelable
import androidx.compose.ui.graphics.Color
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
sealed class RarityTag(val tag: String, val color: @RawValue Color) : Parcelable {
    object Uncommon: RarityTag("Uncommon",  Color.Green)
    object Rare: RarityTag("Rare", Color.Cyan)
    object Epic: RarityTag("Epic", Color.Magenta)
    object Legendary: RarityTag("Legendary", Color.Yellow)
}