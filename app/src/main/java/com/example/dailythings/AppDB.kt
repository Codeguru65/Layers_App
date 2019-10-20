package com.example.dailythings

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [(FeedEntity::class)], version = 1)
abstract class AppDB : RoomDatabase(){
  abstract  fun dailyTaskDao (): dailyDAO
}