package com.migwi.repository

import com.migwi.models.CreateUserParams
import com.migwi.service.UserService
import com.migwi.utils.BaseResponse

class UserRepositoryImpl(
    private val userService: UserService
) : UserRepository {
    override suspend fun registerUser(param: CreateUserParams): BaseResponse<Any> {
        return if (isEmailExist(param.email)) {
            BaseResponse.ErrorResponse(message = "Email already exist")
        } else {
            val user = userService.resisterUser(param)
            if (user != null) {
                //@Todo generate authToken
                BaseResponse.SuccessResponse(data = user)
            } else {
                BaseResponse.ErrorResponse(message = "Email already exist")
            }
        }
    }

    override suspend fun login(email: String, password: String): BaseResponse<Any> {
        TODO("Not yet implemented")
    }

    private suspend fun isEmailExist(email: String): Boolean {
        return userService.findUserByEmail(email) != null
    }
}