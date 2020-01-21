package com.example.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
class Bird_Entity {

    @PrimaryKey(autoGenerate = true)
    var birdId : Int = 1


    @ColumnInfo(name = "quantity")
    var birdQty :Int = 0

}