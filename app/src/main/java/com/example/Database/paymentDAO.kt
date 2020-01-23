package com.example.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface paymentDAO {

    @Insert
    fun savePayTask(task : Payment_Entity)

    @Query("select * from Payment_Entity")
    fun viewPay() : List<Payment_Entity>

}