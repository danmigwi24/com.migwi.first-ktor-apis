package com.migwi.service

import com.migwi.models.User

interface UserService {
    suspend fun resisterUser(params: CreateUserParams): User?
    suspend fun findUserByEmail(email:String):User?

}