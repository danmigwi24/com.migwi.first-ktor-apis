package com.migwi

import com.migwi.db.DatabaseFactory
import com.migwi.repository.UserRepository
import com.migwi.repository.UserRepositoryImpl

import com.migwi.routes.*
import com.migwi.service.UserServiceImpl
import io.ktor.application.*
import io.ktor.features.ContentNegotiation.Feature.install
import io.ktor.jackson.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*


fun main() {
    embeddedServer(Netty, port = 8080, host = "127.0.0.1") {
        DatabaseFactory.init()
        //configureRouting()
        install(ApplicationCallPipeline()) {
            jackson()
        }

        val userService = UserServiceImpl()
        val repository = UserRepositoryImpl(userService = userService)

        authRoutes(repository)
    }.start(wait = true)
}
