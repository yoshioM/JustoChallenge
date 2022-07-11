package com.yoshio.challenge.data.network.model

import com.google.gson.annotations.SerializedName

data class IdModel(
    @SerializedName("name")
    val name: String?,
    @SerializedName("value")
    val value: String?
)
