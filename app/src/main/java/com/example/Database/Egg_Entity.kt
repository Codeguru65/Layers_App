package com.example.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey



@Entity
class Egg_Entity {

    @PrimaryKey(autoGenerate = true)
    var eggid :Int = 0

    @ColumnInfo
    var  date :String? = null

    @ColumnInfo
    var size :String? = null

    @ColumnInfo
    var quality  :String? = null

    @ColumnInfo
    var picked : Int = 0

    @ColumnInfo
    var broken : Int = 0

}