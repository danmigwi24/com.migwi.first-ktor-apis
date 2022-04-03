package com.migwi.models

data class CreateUserParams(
    val fullName: String,
    val email: String,
    val avatar: String,
    var password: String
)
