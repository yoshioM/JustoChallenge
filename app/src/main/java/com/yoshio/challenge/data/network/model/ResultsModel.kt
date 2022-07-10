package com.yoshio.challenge.data.network.model

import com.google.gson.annotations.SerializedName

data class ResultsModel(
    @SerializedName("gender")
    var gender: String,
    @SerializedName("name")
    var name: NameModel,
    @SerializedName("location")
    var location: LocationModel,
    @SerializedName("email")
    var email: String,
    @SerializedName("login")
    var login: LoginModel,
    @SerializedName("dob")
    var dob: DobModel,
    @SerializedName("registered")
    var registered: RegisteredModel,
    @SerializedName("phone")
    var phone: String,
    @SerializedName("cell")
    var cell: String,
    @SerializedName("id")
    var id: IdModel,
    @SerializedName("picture")
    var picture: PictureModel,
    @SerializedName("nat")
    var nat: String
)
