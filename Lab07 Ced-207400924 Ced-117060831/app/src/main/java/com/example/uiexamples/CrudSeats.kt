package com.example.uiexamples

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class CrudSeats : AppCompatActivity() {

    private lateinit var flight: Flight
    private lateinit var persona: Persona
    var flights: Flights = Flights.INSTANCE
    var tickets: Tickets = Tickets.INSTANCE
    var selected: ArrayList<Seat> = ArrayList<Seat>(35)
    private val charPool : List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crud_seats)


        val bundle = intent.extras
        flight =  bundle?.getSerializable("Flight") as Flight
        persona =  bundle?.getSerializable("user") as Persona


        var amount = findViewById<TextView>(R.id.amountDue)

        for(s in flight.seats) {

            var seatId = "seat" + s.number

            val id = resources.getIdentifier(seatId, "id", packageName)

            var seat = findViewById<Button>(id)

            if(s.status){
                seat?.isEnabled = false
                seat?.isClickable = false
                seat?.setBackgroundColor(Color.parseColor("#9F614D"))
                seat?.text = "OC"
            }

            seat?.setOnClickListener {

                if (!s.status) {
                    seat?.setBackgroundColor(Color.parseColor("#9F614D"))
                    s.status = true
                    selected.add(s)

                    amount.text = "" + (flight.seats[0].price * selected.count())


                } else {
                    seat?.setBackgroundColor(Color.parseColor("#E2C792"))
                    s.status = false
                    selected.remove(s)

                    amount.text = "" + (flight.seats[0].price * selected.count())

                }
            }
        }

        var btn_submit = findViewById<Button>(R.id.buyButton)

        // set on-click listener
        btn_submit.setOnClickListener {

            val randomString = (1..10)
                .map { i -> kotlin.random.Random.nextInt(0, charPool.size) }
                .map(charPool::get)
                .joinToString("");

            if(tickets.addTicket(Ticket(randomString, flight.id, flight.seats[0].price * selected.count(), selected, persona.user, 0))){
                flights.editFlight(flight)
                Toast.makeText(this, "Ticket comprado satisfactoriamente.", Toast.LENGTH_SHORT).show()
                finish()
            }


        }

    }
}