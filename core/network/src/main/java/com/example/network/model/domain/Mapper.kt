package com.example.network.model.domain

import android.annotation.SuppressLint
import android.icu.text.SimpleDateFormat
import com.example.network.model.domain.giveaway.Giveaway
import com.example.network.model.domain.opengiveaway.OpenGiveaway
import com.example.network.model.remote.giveaway.GiveawayDto
import com.example.network.model.remote.opengiveaway.OpenGiveawayDto
import java.util.Date


fun GiveawayDto.toGiveaway(): Giveaway = Giveaway(
    description = description,
    endDate = calculateEndDate(endDate),
    gamerPowerUrl = gamerPowerUrl,
    id = id,
    image = image,
    instructions = instructions,
    openGiveawayUrl = openGiveawayUrl,
    platforms = platforms.split(", "),
    publishedDate = publishedDate,
    status = convertStatus(status),
    thumbnail = thumbnail,
    title = title.split(" (")[0],
    type = type,
    users = users,
    worth = giveGamesWorth(worth)
)

fun OpenGiveawayDto.toOpenGiveaway(): OpenGiveaway = OpenGiveaway(
    description = description,
    endDate = calculateEndDate(endDate),
    gamerPowerUrl = gamerPowerUrl,
    id = id,
    image = image,
    instructions = instructions,
    openGiveaway = openGiveaway,
    openGiveawayUrl = openGiveawayUrl,
    platforms = platforms.split(", "),
    publishedDate = publishedDate,
    status = convertStatus(status),
    thumbnail = thumbnail,
    title = title.split(" (")[0],
    type = type,
    users = users,
    worth = giveGamesWorth(worth)
)

fun convertStatus(status: String): Boolean = when (status) {
    "Active" -> true
    else -> false
}

@SuppressLint("SimpleDateFormat")
fun calculateEndDate(endDate: String): String {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    // Get the current date and time
    val currentDate = Date()
    // Parse the target date string
    val targetDate = dateFormat.parse(endDate)
    // Calculate the difference in milliseconds
    return (targetDate.time - currentDate.time).toString()
}

fun giveGamesWorth(worth: String): WorthTag {
    return when (worth) {
        "Uncommon" -> WorthTag.Uncommon
        "Rare" -> WorthTag.Rare
        "Epic" -> WorthTag.Epic
        "Legendary" -> WorthTag.Legendary
        else -> {
            WorthTag.Uncommon
        }
    }
}

