package com.migwi.models

data class  User(
    val id: Int,
    val fullName: String,
    val email: String,
    val avatar: String,
    var authToken: String? = null,
    val createdAt: String
)