package com.example.dailythings

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.intellij.lang.annotations.PrintFormat


@Entity
class FeedEntity {


    @PrimaryKey(autoGenerate = true)
    var date : Int = 0


    @ColumnInfo
    var feed_type5kg : Int=0

    @ColumnInfo
    var feed_type20kg : Int=0

    @ColumnInfo
    var feed_type50kg : Int=0

   /* @ColumnInfo
    var num_bags : String = ""

    @ColumnInfo
    var qty_kg : Float? = 0f*/

   /* @ColumnInfo
    var water : Float? = 0f

    @ColumnInfo
    var death  : Int = 0

    @ColumnInfo
    var eggs_picked : Int = 0

    @ColumnInfo
    var eggs_broken : Int =0

    @ColumnInfo
    var num_lg_eggs : Int = 0

    @ColumnInfo
    var num_md_eggs  : Int = 0

    @ColumnInfo
    var num_sm_eggs : Int = 0

    @ColumnInfo
    var healtth : String = ""*/


}