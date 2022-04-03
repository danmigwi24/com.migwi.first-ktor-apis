package com.migwi.routes

import com.migwi.models.CreateUserParams
import com.migwi.repository.UserRepository
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*


fun Application.authRoutes(repository: UserRepository) {

    routing {
        route("/auth") {
            post("/register") {
                //log.error("results.toString()")
                //call.respondText("Hello World!")
                val params = call.receive<CreateUserParams>()
                val results = repository.registerUser(params)
                call.respond(results.statusCode, results)
            }
        }
    }
}