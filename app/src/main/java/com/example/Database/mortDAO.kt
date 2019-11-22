package com.example.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.selects.select


@Dao
interface mortDAO {

    @Insert
    fun saveMortTask(task : Mort_Entity)

    @Query("select * from Mort_Entity")
    fun viewMort() : List<Mort_Entity>

}