package com.example.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
class DFU_Entity {

    @PrimaryKey(autoGenerate = true)
    var id :Int = 0

    @ColumnInfo(name = "date")
    var  date :String = ""

    @ColumnInfo(name = "feed_type")
    var feedType :String = ""

    @ColumnInfo(name = "quantity")
    var quatity : Float = 0f

    @ColumnInfo(name = "sync_status")
    var syncStatus : Boolean = false

    @ColumnInfo(name = "openning_feed")
    var openningFeed : Float = 0f

    @ColumnInfo(name = "clossing_feed")
    var clossingFeed : Float =0f







}