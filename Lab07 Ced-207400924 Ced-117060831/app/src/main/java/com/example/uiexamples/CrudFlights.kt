package com.example.uiexamples

import android.content.Intent
import android.graphics.Canvas
import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
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

class CrudFlights : AppCompatActivity() {

    var flights: Flights = Flights.INSTANCE

    lateinit var lista:RecyclerView
    lateinit var adaptador:RecyclerView_AdapterFlight
    lateinit var flight: Flight
    var archived = ArrayList<Flight>()
    var position: Int = 0
    private lateinit var persona: Persona

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crud_flights)



        val searchIcon = findViewById<ImageView>(R.id.search_mag_icon)
        searchIcon.setColorFilter(Color.BLACK)


        val cancelIcon = findViewById<ImageView>(R.id.search_close_btn)
        cancelIcon.setColorFilter(Color.BLACK)


        val textView = findViewById<TextView>(R.id.search_src_text)
        textView.setTextColor(Color.BLACK)

        val bundle = intent.extras
        val msg = bundle!!.getString("Origen")

        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()

        lista = findViewById(R.id.lista)
        lista.layoutManager = LinearLayoutManager(lista.context)
        lista.setHasFixedSize(true)

        findViewById<SearchView>(R.id.job_search).setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adaptador.filter.filter(newText)
                return false
            }
        })

        getListOfFlights()

        val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP or ItemTouchHelper.DOWN or ItemTouchHelper.START or ItemTouchHelper.END, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
                    override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                        val fromPosition: Int = viewHolder.adapterPosition
                        val toPosition: Int = target.adapterPosition

                        Collections.swap(flights.getFlights(), fromPosition, toPosition)

                        lista.adapter?.notifyItemMoved(fromPosition, toPosition)

                        return false
                    }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {


                if(direction == ItemTouchHelper.LEFT){
                    Snackbar.make(lista, "Tocar el vuelo para obtener más información", Snackbar.LENGTH_LONG).show()
                    getListOfFlights()
                }else{
                    Snackbar.make(lista, "Tocar el vuelo para obtener más información", Snackbar.LENGTH_LONG).show()
                    getListOfFlights()
                }
            }

            override fun onChildDraw(c: Canvas, recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean) {

                        RecyclerViewSwipeDecorator.Builder(this@CrudFlights, c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                            .addSwipeLeftBackgroundColor(ContextCompat.getColor(this@CrudFlights, R.color.black))
                            .addSwipeRightBackgroundColor(ContextCompat.getColor(this@CrudFlights, R.color.black))
                            .create()
                            .decorate()
                        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                    }

                }
        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(lista)

    }

    private fun getListOfFlights() {
        val NFlights = ArrayList<Flight>()
        for (p in flights.getFlights()) {
            NFlights.add(p)
        }
        adaptador = RecyclerView_AdapterFlight(NFlights)
        lista.adapter = adaptador

        val bundle = intent.extras
        persona =  bundle?.getSerializable("user") as Persona
        adaptador.setUser(persona)

    }

    override fun onRestart() {
        recreate()
        super.onRestart()
    }
}