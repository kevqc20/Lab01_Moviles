package com.example.uiexamples

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class TicketEditActivity : AppCompatActivity() {

    var tickets: Tickets = Tickets.INSTANCE
    private lateinit var ticket: Ticket

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_ticket)


        val bundle = intent.extras
        ticket =  bundle?.getSerializable("Ticket") as Ticket

        var et_id = findViewById(R.id.et_id) as TextView
        var et_flight = findViewById(R.id.et_flight) as TextView
        var et_user = findViewById(R.id.et_user) as TextView
        var et_seat = findViewById(R.id.et_seat) as TextView
        var et_price = findViewById(R.id.et_price) as TextView
        var et_discount = findViewById(R.id.et_discount) as TextView

        et_id?.text = ticket.id
        et_flight?.text = ticket.flight_id
        et_user?.text = ticket.passanger_user
        var text: String = ""
        for(e in ticket.seats){
            text += "" + e.number + " - "
        }
        et_seat?.text = text
        et_price?.text = "" + ticket.price
        et_discount?.text = "" + ticket.discount



    }
}