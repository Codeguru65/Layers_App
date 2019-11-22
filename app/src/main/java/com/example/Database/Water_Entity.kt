package com.example.Database

import androidx.room.Entity
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import androidx.room.ForeignKey

@Entity
class Water_Entity{
    @PrimaryKey(autoGenerate = true)
    var waterid :Int = 0

    @ColumnInfo
    var  wdate :String? = null

    @ColumnInfo
    var level :String? = null

    @ColumnInfo
    var reason : String = ""

}