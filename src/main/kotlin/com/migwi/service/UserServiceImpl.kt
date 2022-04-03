package com.migwi.service

import com.migwi.db.DatabaseFactory
import com.migwi.db.UserTable
import com.migwi.models.CreateUserParams
import com.migwi.models.User
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.statements.InsertStatement

class UserServiceImpl : UserService {
    override suspend fun resisterUser(params: CreateUserParams): User? {
        var statement: InsertStatement<Number>? = null
        DatabaseFactory.dbQuery {
            statement = UserTable.insert {
                it[fullName] = params.fullName
                it[email] = params.email
                it[password] = params.password //@Encrypt password
                it[avatar] = params.avatar
            }
        }
        return rowToUser(statement?.resultedValues?.get(0))
    }

    override suspend fun findUserByEmail(email: String): User? {
        val user = DatabaseFactory.dbQuery {
            UserTable.select { UserTable.email.eq(email) }
                .map { rowToUser(it) }.singleOrNull()
        }
        return user
    }

    private fun rowToUser(row: ResultRow?): User? {
        return if (row == null) null
        else User(
            id = row[UserTable.id],
            fullName = row[UserTable.fullName],
            email = row[UserTable.email],
            avatar = row[UserTable.avatar],
            createdAt = row[UserTable.createdAt].toString()
        )
    }

}