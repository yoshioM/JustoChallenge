package com.yoshio.challenge.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yoshio.challenge.data.database.entities.UsersEntity

@Dao
interface UsersDao {

    @Query("SELECT * FROM user_tbl order by id desc")
    suspend fun getListUsers():List<UsersEntity>

    @Query("SELECT * FROM user_tbl where id = :idDB")
    suspend fun getUserById(idDB:String):UsersEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user:UsersEntity)

    @Query("DELETE FROM user_tbl")
    suspend fun deleteUsersTbl()





}