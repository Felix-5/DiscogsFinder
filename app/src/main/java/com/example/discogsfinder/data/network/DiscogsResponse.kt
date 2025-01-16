package com.example.discogsfinder.data.network

import com.google.gson.annotations.SerializedName

data class DiscogsResponse(
    @SerializedName("results") val results: List<DiscogsRelease>
)

data class DiscogsRelease(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("year") val year: Int?,
    @SerializedName("thumb") val thumb: String?
)

