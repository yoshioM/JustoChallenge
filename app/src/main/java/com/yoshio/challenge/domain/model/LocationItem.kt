package com.yoshio.challenge.domain.model

import com.google.gson.annotations.SerializedName
import com.yoshio.challenge.domain.model.CoordinatesItem
import com.yoshio.challenge.domain.model.StreetItem
import com.yoshio.challenge.domain.model.TimezoneItem

data class LocationItem(
    val street: StreetItem,
    val city: String,
    val state: String,
    val country: String,
    val postcode: String,
    val coordinates: CoordinatesItem,
    val timezone: TimezoneItem
)
