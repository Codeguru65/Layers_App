package com.example.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface eggDAO {

    @Insert
    fun saveEggTask(task : Egg_Entity)

    @Query("select * from Egg_Entity")
    fun viewEgg() : List<Egg_Entity>
}