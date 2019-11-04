package com.example.dailythings

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [(InventoryEntity::class)], version = 1)
abstract class AppDB : RoomDatabase(){
  abstract  fun dailyTaskDao (): InventoryDao
}