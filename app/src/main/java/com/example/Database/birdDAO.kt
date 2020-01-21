package com.example.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface birdDAO {

    @Query("select * from Bird_Entity where birdId is 1")
    fun viewBird() : List<Bird_Entity>

    @Update
    fun addMoreBird(bird : Bird_Entity )

    @Insert
    fun addBird(stock : Bird_Entity)

}