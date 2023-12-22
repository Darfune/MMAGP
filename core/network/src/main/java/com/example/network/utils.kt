package com.example.network

fun buildUrlString(sortBy: String?, platform: String?, type: String?): String {
    var urlString = ""
    urlString += if (platform.isNullOrBlank()) "" else "?platform=$platform"
    urlString += if (type.isNullOrBlank()) "" else {
        if (urlString == "") "?type=$type" else "&type=$type"
    }
    urlString += if (sortBy.isNullOrBlank()) "" else {
        if (urlString == "") "?sort-by=$sortBy" else "&sort-by=$sortBy"
    }
    return urlString
}