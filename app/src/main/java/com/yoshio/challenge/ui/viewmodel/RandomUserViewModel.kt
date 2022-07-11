package com.yoshio.challenge.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yoshio.challenge.domain.GetRandomUserUseCase
import com.yoshio.challenge.domain.model.UserItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RandomUserViewModel @Inject constructor(
    private val getRandomUserUseCase: GetRandomUserUseCase
):ViewModel() {

    val userModel = MutableLiveData<List<UserItem>>()
    val userDetailModel = MutableLiveData<UserItem>()
    val isLoading  = MutableLiveData<Boolean>()
    val showMessage = MutableLiveData<String>()


    fun onCreate(){
        viewModelScope.launch {
            isLoading.postValue(true)

            val result = getRandomUserUseCase()
            if (!result.isNullOrEmpty()){
                userModel.postValue(result)
                isLoading.postValue(false)
            }else{
                isLoading.postValue(false)
                showMessage.postValue("No data to show")
            }
        }
    }

    fun clearData(){
        viewModelScope.launch {
            isLoading.postValue(true)
            getRandomUserUseCase.clearData()
            userModel.postValue(emptyList())
            isLoading.postValue(false)
            showMessage.postValue("Deleted stored data")

        }
    }

    fun getDataFromIdDatabse(idDB: String) {
        viewModelScope.launch {
            isLoading.postValue(true)
            val  result= getRandomUserUseCase.getDataFromIdDatabase(idDB)
            userDetailModel.postValue(result)
            isLoading.postValue(false)
        }
    }
}