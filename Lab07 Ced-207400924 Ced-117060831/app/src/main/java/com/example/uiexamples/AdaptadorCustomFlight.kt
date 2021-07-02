package com.example.uiexamples

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.ArrayList

class RecyclerView_AdapterFlight(private var items: ArrayList<Flight>): RecyclerView.Adapter<RecyclerView.ViewHolder>(), Filterable {

    var itemsList: ArrayList<Flight>? = null

    lateinit var mcontext: Context
    private lateinit var user: Persona

    class FlightHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    init {
        this.itemsList = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val flightListView = LayoutInflater.from(parent.context).inflate(R.layout.templateflights, parent, false)
        val sch = FlightHolder(flightListView)
        mcontext = parent.context
        return sch
    }

    override fun getItemCount(): Int {
        return itemsList?.size!!
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = itemsList?.get(position)
        holder.itemView.findViewById<TextView>(R.id.tvNombre)?.text = item?.origin
        holder.itemView.findViewById<TextView>(R.id.tvLastname)?.text = item?.destination
        holder.itemView.findViewById<TextView>(R.id.tvJob)?.text = item?.date


        holder.itemView.setOnClickListener {
            val intent = Intent(mcontext, CrudSeats::class.java)
            intent.putExtra("user", getUser())
            intent.putExtra("Flight", itemsList?.get(position))
            mcontext.startActivity(intent)
            Log.d("Selected:", itemsList?.get(position)?.id.toString())
        }
    }


    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    itemsList = items
                } else {
                    val resultList = ArrayList<Flight>()
                    for (row in items) {
                        when {
                            row.origin.toLowerCase().contains(charSearch.toLowerCase()) -> {
                                resultList.add(row)
                            }
                            row.destination.toLowerCase().contains(charSearch.toLowerCase()) -> {
                                resultList.add(row)
                            }
                            row.date.toLowerCase().contains(charSearch.toLowerCase()) -> {
                                resultList.add(row)
                            }
                        }
                    }
                    itemsList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = itemsList
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                itemsList = results?.values as ArrayList<Flight>
                notifyDataSetChanged()
            }

        }
    }

    fun getUser() : Persona {
        return user
    }

    fun setUser(p : Persona){
        this.user = p
    }
}

