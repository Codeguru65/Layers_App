package com.example.dailythings

data class Data(val description :String, val quantity : Int)

object Supplier {
    val entityList = listOf<Data>(
        Data("10kg bag",5),
        Data("25kg bag ", 7),
        Data("50kg bag",5),
        Data("10kg 1/4 bag",3),
        Data("10kg 1/2 bag",1),
        Data("10kg 3/4 bag",3),
        Data("25kg 1/4 bag",2),
        Data("25kg 1/2 bag",4),
        Data("25kg 3/4 bag",6),
        Data("50kg 1/4 bag",2),
        Data("50kg 1/2 bag",4),
        Data("50kg 3/4 bag",6)

    )
}
