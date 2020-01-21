package com.example.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey

@Entity
class Debitors_Entity {

    @PrimaryKey(autoGenerate = true)
    var debtId :Int = 0

    @ColumnInfo
    var names: String? = null

    @ColumnInfo
    var  debtDate :String? = null

    @ColumnInfo
    var owingDebt : Float = 0f


}