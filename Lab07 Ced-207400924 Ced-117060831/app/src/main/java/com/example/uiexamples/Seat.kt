package com.example.uiexamples

import java.io.Serializable


class Seat : Serializable {

    var number:Int = 0
    var status:Boolean = false
    var price:Long = 500L


    internal constructor(number:Int, status:Boolean, price:Long){
        this.number = number
        this.status = status
        this.price = price

    }

}