package com.example.uiexamples

class Tickets private constructor() {

    private var tickets: ArrayList<Ticket> = ArrayList<Ticket>()

    init{


    }

    private object HOLDER {
        val INSTANCE = Tickets()
    }

    companion object {
        val INSTANCE: Tickets by lazy {
            HOLDER.INSTANCE
        }
    }

    fun addTicket(ticket: Ticket): Boolean{
        if(tickets?.add(ticket)){
            return true
        }
        return false
    }

    fun getTicket(name: String): Ticket? {
        for (p: Ticket in tickets!!){
            if(p.id.equals(name)){
                return p;
            }
        }
        return null;
    }

    fun getTickets(): ArrayList<Ticket>{
        return this.tickets!!
    }

    fun deleteTicket(position: Int){
        tickets!!.removeAt(position)
    }

    fun editTicket(p: Ticket, position: Int){
        var aux = tickets.find { a -> a.id == p.id }
        aux?.id = p.id
        aux?.flight_id = p.flight_id
        aux?.price =  p.price
        aux?.seats = p.seats
        aux?.passanger_user = p.passanger_user
        aux?.discount = p.discount


    }
}