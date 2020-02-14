package com.example.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
class Creditors_Entity {

    @PrimaryKey(autoGenerate = true)
    var credId :Int = 0

    @ColumnInfo
    var credNames: String? = null

    @ColumnInfo
    var  credDate :String? = null

    @ColumnInfo
    var owingCred : Float = 0f


}