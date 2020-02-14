package com.example.Database

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [(DFU_Entity::class), (Egg_Entity::class), (Inventory_Entity::class), (Water_Entity::class), (Mort_Entity::class),(Health_Entity::class), (Part_Entity::class),(Stock_Entity::class),(User_Entity::class),(Bird_Entity::class), (Debitors_Entity::class), (Creditors_Entity::class), (Payment_Entity::class), (Client_Entity::class)],version = 1 )


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
    abstract fun userTask(): userDAO
    abstract fun birdTask(): birdDAO
    abstract fun debtTask(): debitorsDAO
    abstract fun payTask(): paymentDAO
    abstract fun credTask(): creditorsDOA
    abstract fun clientTask(): clientsDAO

}
