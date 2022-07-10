package com.yoshio.challenge.domain.model

import com.google.gson.annotations.SerializedName

data class LoginItem(
    val uuid: String,
    val username: String,
    val password: String,
    val salt: String,
    val md5: String,
    val sha1: String,
    val sha256: String
)
