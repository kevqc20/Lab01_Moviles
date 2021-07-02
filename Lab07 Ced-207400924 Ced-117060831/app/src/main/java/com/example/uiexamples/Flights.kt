package com.example.uiexamples

class Flights private constructor() {

    private var flights: ArrayList<Flight> = ArrayList<Flight>()

    init{
        addFlight(Flight("1", "1", "1", "1", "Costa Rica", "USA", "13-06-21"))
        addFlight(Flight("2", "2", "2", "2", "Costa Rica", "Italia", "11-05-21"))

        flights[0].seats[5].status = true

    }

    private object HOLDER {
        val INSTANCE = Flights()
    }

    companion object {
        val INSTANCE: Flights by lazy {
            HOLDER.INSTANCE
        }
    }

    fun addFlight(flight: Flight){
        flights?.add(flight)
    }

    fun getFlight(name: String): Flight? {
        for (p: Flight in flights!!){
            if(p.id.equals(name)){
                return p;
            }
        }
        return null;
    }

    fun getFlights(): ArrayList<Flight>{
        return this.flights!!
    }

    fun deleteFlight(position: Int){
        flights!!.removeAt(position)
    }

    fun editFlight(p: Flight){
        var aux = flights.find { a -> a.id == p.id }
        aux?.id = p.id
        aux?.route_id = p.route_id
        aux?.airplane_id = p.airplane_id
        aux?.schedule_id = p.schedule_id
        aux?.origin = p.origin
        aux?.date = p.date
        aux?.seats = p.seats

    }
}