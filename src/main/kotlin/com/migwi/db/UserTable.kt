package com.migwi.db

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.datetime
import java.time.LocalDateTime

object UserTable : Table("users") {
    val id = integer("id").autoIncrement()
    val fullName = varchar(name = "full_name", length = 256)
    val email = varchar(name = "email", length = 256)
    val avatar = text(name = "avatar")
    val password = varchar(name = "password", length = 256)
    val createdAt = datetime(name = "created_at").clientDefault { LocalDateTime.now() }
    override val primaryKey = PrimaryKey(id)


}