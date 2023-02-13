package com.arturomarmolejo.exomusicapp.model.items


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TrackResponse(
    @Json(name = "artistId")
    val artistId: Int?,
    @Json(name = "artistName")
    val artistName: String,
    @Json(name = "artworkUrl60")
    val artworkUrl60: String,
    @Json(name = "collectionName")
    val collectionName: String,
    @Json(name = "collectionPrice")
    val collectionPrice: Double,
    @Json(name = "collectionViewUrl")
    val collectionViewUrl: String,
    @Json(name = "country")
    val country: String,
    @Json(name = "previewUrl")
    val previewUrl: String,
    @Json(name = "trackId")
    val trackId: Int?,
    @Json(name = "trackName")
    val trackName: String?,
    @Json(name = "trackNumber")
    val trackNumber: Int?,
    @Json(name = "trackPrice")
    val trackPrice: Double?,
)