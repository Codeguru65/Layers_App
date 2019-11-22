package com.example.dailythings

data class Data(val description :String, val quantity : Float)

data class DataH(val description :String, val quantity : Float, val id : Int)

object Supplier {


    val entityList = listOf<Data>(
        Data("10kg bag",5f),
        Data("25kg bag ", 7f),
        Data("50kg bag",5f),
        Data("10kg 1/4 bag",3f),
        Data("10kg 1/2 bag",1f),
        Data("10kg 3/4 bag",3f),
        Data("25kg 1/4 bag",2f),
        Data("25kg 1/2 bag",4f),
        Data("25kg 3/4 bag",6f),
        Data("50kg 1/4 bag",2f),
        Data("50kg 1/2 bag",4f),
        Data("50kg 3/4 bag",6f)

    )
}
