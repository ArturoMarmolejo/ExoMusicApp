package com.arturomarmolejo.exomusicapp.model.items


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TrackListResponse(
    @Json(name = "resultCount")
    val resultCount: Int,
    @Json(name = "results")
    val results: List<Result>
)