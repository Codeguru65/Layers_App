package com.example.Database

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [(DFU_Entity::class), (Egg_Entity::class)],version = 1 )
abstract class AppDb : RoomDatabase()
{
    abstract  fun feedTaskDAO (): feedDAO
    abstract fun eggTaskDAO (): eggDAO
}