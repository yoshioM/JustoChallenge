package com.yoshio.challenge.data.network.model

import com.google.gson.annotations.SerializedName

data class LocationModel(
    @SerializedName("street")
    val street: StreetModel,
    @SerializedName("city")
    val city: String,
    @SerializedName("state")
    val state: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("postcode")
    val postcode: String,
    @SerializedName("coordinates")
    val coordinates: CoordinatesModel,
    @SerializedName("timezone")
    val timezone: TimezoneModel
)
