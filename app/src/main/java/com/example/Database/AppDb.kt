package com.example.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.production.Inventory
import com.mysql.jdbc.authentication.CachingSha2PasswordPlugin


@Database(entities = [(DFU_Entity::class), (Egg_Entity::class), (Inventory_Entity::class), (Water_Entity::class), (Mort_Entity::class),(Health_Entity::class), (Part_Entity::class),(Stock_Entity::class)],version = 1 )


abstract class AppDb : RoomDatabase()
{
    abstract  fun feedTaskDAO (): feedDAO
    abstract fun eggTaskDAO (): eggDAO
    abstract  fun inventoryDAO():inventoryDAO
    abstract fun waterTask(): waterDAO
    abstract fun mortTask(): mortDAO
    abstract fun healthTask(): healthDAO
    abstract fun partTask(): partpayDAO
    abstract fun stockTask(): stockDAO

}
