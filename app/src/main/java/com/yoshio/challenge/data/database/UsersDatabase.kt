package com.yoshio.challenge.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yoshio.challenge.data.database.dao.UsersDao
import com.yoshio.challenge.data.database.entities.UsersEntity

@Database(entities = [UsersEntity::class], version = 1)
abstract class UsersDatabase: RoomDatabase() {
    abstract fun getUsersDao(): UsersDao
}