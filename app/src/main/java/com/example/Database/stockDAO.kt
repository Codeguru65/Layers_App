package com.example.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface stockDAO {

    @Query("select * from Stock_Entity where stockId is 1")
    fun viewStock() : List<Stock_Entity>

    @Update
    fun addMoreEggs(stock : Stock_Entity )

    @Insert
    fun addEggs(stock : Stock_Entity )

}