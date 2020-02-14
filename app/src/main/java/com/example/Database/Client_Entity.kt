package com.example.Database


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Client_Entity(){

    @PrimaryKey(autoGenerate = true)
    var clientID: Int = 0

    @ColumnInfo
    var nameClient: String? = null

    @ColumnInfo
    var clientType: String? = null

    @ColumnInfo
    var address: String? = null

    @ColumnInfo
    var phone: String? = null

    @ColumnInfo
    var email: String? = null

}