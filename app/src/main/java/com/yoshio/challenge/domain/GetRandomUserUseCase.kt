package com.yoshio.challenge.domain

import androidx.lifecycle.ViewModel
import com.yoshio.challenge.data.UserRepository
import com.yoshio.challenge.domain.model.UserItem
import javax.inject.Inject

class GetRandomUserUseCase @Inject constructor(
    private val repository: UserRepository
){
    suspend operator fun invoke(): List<UserItem>{
        val userData = repository.getUserValuesFromApi();

        return if (userData != null){
            listOf(userData)
        }else{
            emptyList()
        }
    }
}