package com.example.dailythings

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface InventoryDao {


    @Insert
    fun addItem (item : InventoryEntity)

    @Query("select * from inventoryentity")
    fun viewInventoty (): List<InventoryEntity>
}