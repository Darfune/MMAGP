package com.example.network.model.domain.giveaway

import android.os.Parcelable
import com.example.network.model.domain.RarityTag
import kotlinx.parcelize.Parcelize

@Parcelize
data class Giveaway (
    val description: String,
    val endDate: String,
    val gamerPowerUrl: String,
    val id: Int,
    val image: String,
    val instructions: String,
    val openGiveawayUrl: String,
    val platforms: List<String>,
    val publishedDate: String,
    val status: Boolean,
    val thumbnail: String,
    val title: String,
    val type: String,
    val users: Int,
    val worth: String,
    val rarity: RarityTag
): Parcelable