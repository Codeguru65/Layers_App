package com.example.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface inventoryDAO {

    @Query("select * from Inventory_Entity")
    fun viewFeed() : List<Inventory_Entity>

    @Query("select * from Inventory_Entity where id = :id")
    fun readFeed(id : Int) : List<Inventory_Entity>

    @Insert
    fun addtem(item : Inventory_Entity)

    @Update
    fun addMoreFeed(feed : Inventory_Entity)




}