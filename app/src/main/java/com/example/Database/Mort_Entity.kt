package com.example.Database

import androidx.room.Entity
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import androidx.room.ForeignKey

@Entity
class Mort_Entity{
    @PrimaryKey(autoGenerate = true)
    var mortid :Int = 0

    @ColumnInfo
    var  mdate :String? = null

    @ColumnInfo
    var mortNum : Int = 0

    @ColumnInfo
    var mcause : String? = null


}