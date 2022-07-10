package com.yoshio.challenge.data

import com.yoshio.challenge.data.network.UserService
import com.yoshio.challenge.domain.model.UserItem
import com.yoshio.challenge.domain.model.toDomain
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val api: UserService
) {

    suspend fun getUserValuesFromApi(): UserItem {
        val response = api.getRandomUser()
        return response.toDomain()
    }
}