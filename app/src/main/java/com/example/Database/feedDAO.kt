package com.example.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface feedDAO {

    @Insert
    fun saveFeedTask(task : DFU_Entity)

    @Query("select * from DFU_Entity")
    fun viewFeed() : List<DFU_Entity>
}