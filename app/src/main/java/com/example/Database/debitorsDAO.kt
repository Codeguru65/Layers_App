package com.example.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface debitorsDAO {

    @Query("select * from Debitors_Entity where names is :name")
    fun viewDebt(name: String) : List<Debitors_Entity>

    @Query("select * from Debitors_Entity")
    fun viewDebitors() : List<Debitors_Entity>

    @Update
    fun updateDebt(debt : Debitors_Entity )

    @Insert
    fun addDebt(stock : Debitors_Entity)

}