package com.yoshio.challenge.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yoshio.challenge.domain.GetRandomUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GetRandomUserViewModel @Inject constructor(
    private val getRandomUserUseCase: GetRandomUserUseCase
):ViewModel() {


    fun onCreate(){
        viewModelScope.launch {
            val result = getRandomUserUseCase()
            if (!result.isNullOrEmpty()){

            }
        }
    }
}