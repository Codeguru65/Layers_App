package com.example.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
class Stock_Entity {

    @PrimaryKey(autoGenerate = true)
    var stockId : Int = 1

    @ColumnInfo(name = "item")
    var stockItem :String = ""

    @ColumnInfo(name = "quantity")
    var stockQty :Int = 0

}