package com.erick.apppasteleria.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo("usuario")
    val username: String,
    @ColumnInfo("email")
    val password: String
)