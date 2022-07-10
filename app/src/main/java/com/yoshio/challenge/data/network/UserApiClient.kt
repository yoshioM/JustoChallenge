package com.yoshio.challenge.data.network

import com.yoshio.challenge.data.network.model.UserModel
import retrofit2.Response
import retrofit2.http.GET

interface UserApiClient {
    @GET("api/")
    suspend fun getRandomUser(): Response<UserModel>
}