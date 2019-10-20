package com.example.dailythings

import androidx.room.Dao
import androidx.room.Insert


@Dao
interface dailyDAO {

    @Insert
    fun saveTask(feed: FeedEntity)
}