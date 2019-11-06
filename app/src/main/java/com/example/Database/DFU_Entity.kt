package com.example.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
class DFU_Entity {

    @PrimaryKey(autoGenerate = true)
    var id :Int = 0

    @ColumnInfo
    var  date :String? = null

    @ColumnInfo
    var feedType :String? = null

    @ColumnInfo
    var quatity : Int = 0




}