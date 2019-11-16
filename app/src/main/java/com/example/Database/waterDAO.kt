package com.example.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.selects.select


@Dao
interface waterDAO {

    @Insert
    fun saveWaterTask(task : Water_Entity)

    @Query("select * from Water_Entity")
    fun viewWater() : List<Water_Entity>




}
