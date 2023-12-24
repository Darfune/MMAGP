package com.example.network.model.domain.opengiveaway

import com.example.network.model.domain.WorthTag
import kotlinx.serialization.SerialName

data class OpenGiveaway (
    val description: String,
    val endDate: String,
    val gamerPowerUrl: String,
    val id: Int,
    val image: String,
    val instructions: String,
    val openGiveaway: String,
    val openGiveawayUrl: String,
    val platforms: List<String>,
    val publishedDate: String,
    val status: Boolean,
    val thumbnail: String,
    val title: String,
    val type: String,
    val users: Int,
    val worth: WorthTag
)