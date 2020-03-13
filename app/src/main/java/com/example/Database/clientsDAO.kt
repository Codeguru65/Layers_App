package com.example.Database

import androidx.room.*
import kotlinx.coroutines.selects.select


@Dao

interface clientsDAO{

    @Query("select * from Client_Entity")
    fun veiwClient(): List<Client_Entity>

    @Insert
    fun addClient(client: Client_Entity)

    @Update
    fun updateClient(client: Client_Entity)

    @Query("select * from Client_Entity where clientType is :type")
    fun viewSp(type: String): List<Client_Entity>

    @Query("select * from Client_Entity where nameClient like :phrase")
    fun fil(phrase: String?): List<Client_Entity>

    @Query("select * from Client_Entity where :type > 0.0 and :type <=  5000000.0")
    fun viewBal(type: String): List<Client_Entity>

    @Query("select * from Client_Entity where nameClient is :phrase")
    fun viewD(phrase: String): List<Client_Entity>


    @Query("select * from Client_Entity")
    abstract fun viewClient(): List<Client_Entity>

}