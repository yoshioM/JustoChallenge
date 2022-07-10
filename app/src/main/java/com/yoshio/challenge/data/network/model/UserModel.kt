package com.yoshio.challenge.data.network.model

import com.google.gson.annotations.SerializedName

data class UserModel(
    @SerializedName("results")
    val results: List<ResultsModel>,
    @SerializedName("info")
    val info: InfoModel
) {

}
