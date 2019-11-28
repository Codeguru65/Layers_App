package com.example.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.selects.select

@Dao
interface userDAO {

    @Query("select * from User_Entity where username = :user or email = :user" )
    fun viewUser(user: String) : User_Entity


    @Insert()
    fun addUser(item : User_Entity)

    @Query("select * from User_Entity  ")
    fun checkUsers():  List<User_Entity>
}