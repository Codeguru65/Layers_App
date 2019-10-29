package com.example.dailythings

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
class FeedEntity() {



    @PrimaryKey(autoGenerate = true)
    var id : Int = 0


    @ColumnInfo
    var feed_type : String = ""

    @ColumnInfo
    var quantity : Int = 0





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

