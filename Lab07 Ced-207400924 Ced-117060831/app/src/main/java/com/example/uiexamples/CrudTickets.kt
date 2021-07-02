package com.example.uiexamples

import android.content.Intent
import android.graphics.Canvas
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator
import java.util.*
import kotlin.collections.ArrayList

class CrudTickets : AppCompatActivity() {

    var tickets: Tickets = Tickets.INSTANCE
    var flights: Flights = Flights.INSTANCE


    lateinit var lista:RecyclerView
    lateinit var adaptador:RecyclerView_AdapterTicket
    lateinit var ticket: Ticket
    var archived = ArrayList<Ticket>()
    var position: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crud_tickets)


        val searchIcon = findViewById<ImageView>(R.id.search_mag_icon)
        searchIcon.setColorFilter(Color.BLACK)


        val cancelIcon = findViewById<ImageView>(R.id.search_close_btn)
        cancelIcon.setColorFilter(Color.BLACK)


        val textView = findViewById<TextView>(R.id.search_src_text)
        textView.setTextColor(Color.BLACK)

        lista = findViewById(R.id.listaTicket)
        lista.layoutManager = LinearLayoutManager(lista.context)
        lista.setHasFixedSize(true)

        findViewById<SearchView>(R.id.ticket_search).setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adaptador.filter.filter(newText)
                return false
            }
        })

        getListOfTickets()

        val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP or ItemTouchHelper.DOWN or ItemTouchHelper.START or ItemTouchHelper.END, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
                    override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                        val fromPosition: Int = viewHolder.adapterPosition
                        val toPosition: Int = target.adapterPosition

                        Collections.swap(tickets.getTickets(), fromPosition, toPosition)

                        lista.adapter?.notifyItemMoved(fromPosition, toPosition)

                        return false
                    }

                    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                        position = viewHolder.adapterPosition
                        var quien: String = ""

                        if(direction == ItemTouchHelper.LEFT){
                            ticket = Ticket(tickets.getTickets()[position].id, tickets.getTickets()[position].flight_id, tickets.getTickets()[position].price, tickets.getTickets()[position].seats, tickets.getTickets()[position].passanger_user, tickets.getTickets()[position].discount)
                            tickets.deleteTicket(position)

                            var flight : Flight? = flights.getFlight(ticket.flight_id)

                            for(s in ticket.seats){
                                flight?.seats?.filter { a -> a.number == s.number }?.forEach{ a -> a.status = false}
                            }


                            lista.adapter?.notifyItemRemoved(position)
                            adaptador = RecyclerView_AdapterTicket(tickets.getTickets())
                            lista.adapter = adaptador
                            Snackbar.make(lista, ticket.id + "Se eliminaría...", Snackbar.LENGTH_LONG).setAction("Undo") {
                                tickets.getTickets().add(position, ticket)
                                lista.adapter?.notifyItemInserted(position)
                                adaptador = RecyclerView_AdapterTicket(tickets.getTickets())
                                lista.adapter = adaptador
                                getListOfTickets()
                            }.show()
                            getListOfTickets()
                        }else{
                            ticket = Ticket(tickets.getTickets()[position].id, tickets.getTickets()[position].flight_id, tickets.getTickets()[position].price, tickets.getTickets()[position].seats, tickets.getTickets()[position].passanger_user, tickets.getTickets()[position].discount)

                            val intent = Intent(lista.context, TicketEditActivity::class.java)
                            intent.putExtra("Ticket", ticket)
                            lista.context.startActivity(intent)

                            getListOfTickets()
                        }
                    }

                    override fun onChildDraw(c: Canvas, recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean) {


                        RecyclerViewSwipeDecorator.Builder(this@CrudTickets, c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                            .addSwipeLeftBackgroundColor(ContextCompat.getColor(this@CrudTickets, R.color.red))
                            .addSwipeLeftActionIcon(R.drawable.ic_baseline_delete_24)
                            .addSwipeRightBackgroundColor(ContextCompat.getColor(this@CrudTickets, R.color.green))
                            .addSwipeRightActionIcon(R.drawable.ic_menu_send)
                            .create()
                            .decorate()
                        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                    }

                }



        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(lista)


    }

    private fun getListOfTickets() {
        val Ntickets = ArrayList<Ticket>()
        val extras = intent.extras
        val user = extras!!.getString("user")
        for (p in tickets.getTickets()) {
            if (p.passanger_user == user) {
                Ntickets.add(p)
            }

        }
        adaptador = RecyclerView_AdapterTicket(Ntickets)
        lista.adapter = adaptador
    }
}