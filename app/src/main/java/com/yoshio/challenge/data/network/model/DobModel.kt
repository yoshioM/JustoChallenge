package com.yoshio.challenge.data.network.model

import com.google.gson.annotations.SerializedName

data class DobModel(
    @SerializedName("date")
    val date: String,
    @SerializedName("age")
    val age: Int
)
