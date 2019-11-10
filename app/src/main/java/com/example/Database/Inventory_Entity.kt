package com.example.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
class Inventory_Entity {

    @PrimaryKey(autoGenerate = true)
    var id : Int =0

    @ColumnInfo(name = "item")
    var item :String = ""

    @ColumnInfo(name = "quantity")
    var qty :Float = 0f

}