package com.example.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
class User_Entity {

    @PrimaryKey(autoGenerate = true)
    var userid :Int = 0

    @ColumnInfo
    var  fname :String = ""

    @ColumnInfo
    var lname :String = ""

    @ColumnInfo
    var email : String = ""

    @ColumnInfo
    var username : String = ""

    @ColumnInfo
    var password : String = ""

}