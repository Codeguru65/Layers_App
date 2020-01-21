package com.example.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey

@Entity
class Part_Entity {

    @PrimaryKey(autoGenerate = true)
    var partid :Int = 0


    @ColumnInfo
    var names: String = "Cash"

    @ColumnInfo
    var  partDate :String? = null

    @ColumnInfo
    var partProduct :String? = null

    @ColumnInfo
    var type : String? = null

    @ColumnInfo
    var partQuantity  :Int = 0

    @ColumnInfo
    var totalP : Float = 0f

    @ColumnInfo
    var paidPart : Float = 0f

    @ColumnInfo
    var owingP : Float = 0f


}