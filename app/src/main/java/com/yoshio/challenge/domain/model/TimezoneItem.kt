package com.yoshio.challenge.domain.model

import com.google.gson.annotations.SerializedName

data class TimezoneItem(
    val offset: String,
    val description: String
)
