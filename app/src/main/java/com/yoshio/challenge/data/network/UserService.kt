package com.yoshio.challenge.data.network

import android.util.Log
import com.google.gson.Gson
import com.yoshio.challenge.data.network.model.InfoModel
import com.yoshio.challenge.data.network.model.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.security.auth.login.LoginException

class UserService @Inject constructor(
    private val api: UserApiClient
) {

    suspend fun getRandomUser(): UserModel{
        try {
            return withContext(Dispatchers.IO) {
                val response = api.getRandomUser()
                Log.e("RESPONSE: ", Gson().toJson(response.body()))
                if (response.isSuccessful) {
                    response.body() ?: UserModel(emptyList(), InfoModel("", 0, 0, ""))
                }else {
                    UserModel(emptyList(), InfoModel("", 0, 0, ""))
                }
            }
        }catch (ex:Exception){
            ex.printStackTrace()
            return UserModel(emptyList(), InfoModel("", 0, 0, ""))
        }
    }
}