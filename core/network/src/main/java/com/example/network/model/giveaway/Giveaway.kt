package com.example.network.model.giveaway


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Giveaway(
    val description: String,
    @SerialName("end_date")
    val endDate: String,
    @SerialName("gamerpower_url")
    val gamerPowerUrl: String,
    val id: Int,
    val image: String,
    val instructions: String,
    @SerialName("open_giveaway_url")
    val openGiveawayUrl: String,
    val platforms: String,
    @SerialName("published_date")
    val publishedDate: String,
    val status: String,
    val thumbnail: String,
    val title: String,
    val type: String,
    val users: Int,
    val worth: String
)