package com.example.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface partpayDAO {

    @Insert
    fun savePartTask(task : Part_Entity)

    @Query("select * from Part_Entity")
    fun viewPart() : List<Part_Entity>
}