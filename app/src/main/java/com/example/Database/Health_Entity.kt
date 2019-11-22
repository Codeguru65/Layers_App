package com.example.Database

import androidx.room.Entity
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import androidx.room.ForeignKey

@Entity
class Health_Entity{
    @PrimaryKey(autoGenerate = true)
    var healthid :Int = 0

    @ColumnInfo
    var  hdate :String = ""

    @ColumnInfo
    var healthS :String = ""

    @ColumnInfo
    var hcause : String = ""


}

