package com.example.uiexamples

import java.io.Serializable


class Persona : Serializable {

    var user:String = ""
    var password:String = ""
    var name:String = ""
    var lastname:String = ""
    var email:String = ""
    var address:String = ""
    var cellphone:Int = 0
    var workphone:Int = 0

    internal constructor(user:String, password:String, name:String, lastname:String, email:String, address:String, cellphone:Int, workphone:Int){
        this.user = user
        this.password = password
        this.name = name
        this.lastname = lastname
        this.email = email
        this.address = address
        this.cellphone = cellphone
        this.workphone = workphone
    }

}