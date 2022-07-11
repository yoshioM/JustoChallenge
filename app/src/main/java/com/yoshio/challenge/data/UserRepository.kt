package com.yoshio.challenge.data

import com.yoshio.challenge.data.database.dao.UsersDao
import com.yoshio.challenge.data.database.entities.UsersEntity
import com.yoshio.challenge.data.network.UserService
import com.yoshio.challenge.domain.model.UserItem
import com.yoshio.challenge.domain.model.toDomain
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val api: UserService,
    private val dao: UsersDao
) {

    suspend fun getUserValuesFromApi(): UserItem {
        val response = api.getRandomUser()
        return response.toDomain()
    }

    suspend fun getUsersFromDatabase(): List<UserItem>{
        val response = dao.getListUsers()
        return response.map{ it.toDomain()}
    }

    suspend fun insertUserDatabase(user:UsersEntity) {
        dao.insertUser(user)
    }
    suspend fun clearUserTbl() {
        dao.deleteUsersTbl()
    }
}