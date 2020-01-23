package com.example.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey

@Entity
class Payment_Entity {

    @PrimaryKey(autoGenerate = true)
    var payid :Int = 0

    @ColumnInfo
    var nameS: String = "General Store"

    @ColumnInfo
    var  payDate :String? = null

    @ColumnInfo
    var payProduct :String? = null

    @ColumnInfo
    var payType : String? = null

    @ColumnInfo
    var payQuantity  :Int = 0

    @ColumnInfo
    var totalPay : Float = 0f

    @ColumnInfo
    var paidPay : Float = 0f

    @ColumnInfo
    var owingPay : Float = 0f


}