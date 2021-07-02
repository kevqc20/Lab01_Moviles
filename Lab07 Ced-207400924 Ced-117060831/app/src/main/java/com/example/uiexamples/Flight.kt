package com.example.uiexamples

import java.io.Serializable


class Flight : Serializable {

    var id:String = ""
    var route_id:String = ""
    var airplane_id:String = ""
    var schedule_id:String = ""
    var origin:String = ""
    var destination:String = ""
    var date:String = ""
    var seats: ArrayList<Seat>

    internal constructor(user:String, lastname:String, street:String, street2:String, state:String, city:String,email:String){
        this.id = user
        this.route_id = lastname
        this.airplane_id = street
        this.schedule_id = street2
        this.origin = state
        this.destination = city
        this.date = email
        seats = ArrayList<Seat>(25)
        var x = 1
        while(x <= 25){
            seats.add(Seat(x, false, 800))
            x++
        }

    }

}