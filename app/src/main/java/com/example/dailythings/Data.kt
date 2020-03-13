package com.example.dailythings

import android.telephony.PhoneNumberUtils


data class Data(val description :String?, val quantity : Float)

data class DataH(val description :String, val quantity : Float, val date : String?)

data class DataC(val name : String?, val type: String?, val contact: String?)

data class Trans(val name: String?, val id : Int , val date: String?, val bal: Float, val tot: Float, val type: String? )



