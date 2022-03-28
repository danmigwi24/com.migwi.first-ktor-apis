package com.migwi.service

data class CreateUserParams(
    val fullName: String,
    val email: String,
    val avatar: String,
    var password: String
)
