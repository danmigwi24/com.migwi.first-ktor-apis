package com.migwi.routes

import com.migwi.repository.UserRepository
import com.migwi.service.CreateUserParams
import io.ktor.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.authRoutes(repository: UserRepository) {

    routing {
        route("/auth") {
            post("/register") {
                val params = call.receive<CreateUserParams>()
                val results = repository.registerUser(params)
                call.respond(results.statusCode, results)
            }
        }
    }
}