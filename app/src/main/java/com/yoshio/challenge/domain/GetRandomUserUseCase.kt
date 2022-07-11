package com.yoshio.challenge.domain

import androidx.lifecycle.ViewModel
import com.yoshio.challenge.data.UserRepository
import com.yoshio.challenge.data.database.entities.toDatabase
import com.yoshio.challenge.domain.model.UserItem
import javax.inject.Inject

class GetRandomUserUseCase @Inject constructor(
    private val repository: UserRepository
){
    suspend operator fun invoke(): List<UserItem>{
        val userData = repository.getUserValuesFromApi();

         if (userData != null){
            repository.insertUserDatabase(userData.toDatabase())
        }

        var storedData = repository.getUsersFromDatabase()

        return if (!storedData.isNullOrEmpty()){
            storedData
        }else{
            emptyList()
        }
    }
    suspend fun clearData(){
        repository.clearUserTbl()
    }

    suspend fun getDataFromIdDatabase(idDB: String): UserItem {
       return repository.getUserValuesFromDatabaseId(idDB)
    }
}