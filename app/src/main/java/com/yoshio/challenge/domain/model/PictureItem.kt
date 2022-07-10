package com.yoshio.challenge.domain.model

import com.google.gson.annotations.SerializedName

data class PictureItem(
    val large: String,
    val medium: String,
    val thumbnail: String
)
