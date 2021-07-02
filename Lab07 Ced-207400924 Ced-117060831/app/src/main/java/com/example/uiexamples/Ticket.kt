package com.example.uiexamples

import java.io.Serializable


class Ticket : Serializable {

    var id:String = ""
    var flight_id:String = ""
    var price:Long = 0
    var seats: ArrayList<Seat> = ArrayList<Seat>(35)
    var passanger_user:String = ""
    var discount:Int = 0



    internal constructor(id:String, flight_id:String, price:Long, seats:ArrayList<Seat>, passanger_user:String, discount:Int){
        this.id = id
        this.flight_id = flight_id
        this.price = price
        this.seats = seats
        this.passanger_user = passanger_user
        this.discount = discount
    }

}