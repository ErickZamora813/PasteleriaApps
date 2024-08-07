package com.erick.apppasteleria.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert
     fun insert( user: User)

    @Query("SELECT * FROM users WHERE usuario = :username AND email = :password")
     fun getUser(username: String, password: String): User?

    @Query("SELECT * FROM users WHERE usuario = :username")
    fun getByUserName(username: String): Flow<User?>
}