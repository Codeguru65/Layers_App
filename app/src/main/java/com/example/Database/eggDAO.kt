package com.example.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface eggDAO {

    @Insert
    fun saveEggTask(task : Egg_Entity)

    @Query("select * from Egg_Entity")
    fun viewEgg() : List<Egg_Entity>

    @Update
    fun updateEgg(egg: Egg_Entity )

    @Query( "select * from Egg_Entity where date is :dte")
    fun viewEggHistory(dte: String): List<Egg_Entity>


}

