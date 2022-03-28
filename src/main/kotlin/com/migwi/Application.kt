package com.migwi

import com.migwi.db.DatabaseFactory

import com.migwi.routes.*
import io.ktor.auth.Authentication.Feature.install
import io.ktor.client.features.*

import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "127.0.0.1") {
       DatabaseFactory.init()
        configureRouting()
        //
        //implementation ("io.ktor:ktor-server-content-negotiation-jvm:1.6.8")
//        install(ContentNegotiation){
//            jackson()
//        }
    }.start(wait = true)
}
