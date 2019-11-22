package com.example.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.selects.select


@Dao
interface healthDAO {

    @Insert
    fun saveHealthTask(task : Health_Entity)

    @Query("select * from Health_Entity")
    fun viewHealth() : List<Health_Entity>

}