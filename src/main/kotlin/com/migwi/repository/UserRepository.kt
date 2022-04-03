package com.migwi.repository

import com.migwi.models.CreateUserParams
import com.migwi.utils.BaseResponse

interface UserRepository {

    suspend fun registerUser(param: CreateUserParams):BaseResponse<Any>
    suspend fun login(email:String,password:String):BaseResponse<Any>

}