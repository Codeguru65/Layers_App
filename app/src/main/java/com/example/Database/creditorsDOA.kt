package com.example.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface creditorsDOA {

    @Query("select * from Creditors_entity where credNames = :name ")
    fun viewCred(name: String) : List<Creditors_Entity>

    @Query("select * from Creditors_Entity")
    fun viewCreditors() : List<Creditors_Entity>

    @Update
    fun updateCred(debt : Creditors_Entity )

    @Insert
    fun addCred(stock : Creditors_Entity)

}