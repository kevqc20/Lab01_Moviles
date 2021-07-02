package com.example.uiexamples

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.uiexamples.ui.Login
import java.util.*
import kotlin.collections.ArrayList

class RecyclerView_AdapterTicket(private var items: ArrayList<Ticket>): RecyclerView.Adapter<RecyclerView.ViewHolder>(), Filterable {

    var itemsList: ArrayList<Ticket>? = null

    lateinit var mcontext: Context

    class TicketHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    init {
        this.itemsList = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val ticketListView = LayoutInflater.from(parent.context).inflate(R.layout.templatetickets, parent, false)
        val sch = TicketHolder(ticketListView)
        mcontext = parent.context
        return sch
    }

    override fun getItemCount(): Int {
        return itemsList?.size!!
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = itemsList?.get(position)
        holder.itemView.findViewById<TextView>(R.id.tv_ticket_id)?.text = item?.id
        holder.itemView.findViewById<TextView>(R.id.tv_ticket_user)?.text = item?.passanger_user
        holder.itemView.findViewById<TextView>(R.id.tv_ticket_price)?.text = item?.price.toString()
        holder.itemView.findViewById<TextView>(R.id.tv_ticket_discount)?.text = item?.discount.toString()


        holder.itemView.setOnClickListener {
            val intent = Intent(mcontext, TicketEditActivity::class.java)
            intent.putExtra("Ticket", itemsList?.get(position))
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
                    val resultList = ArrayList<Ticket>()
                    for (row in items) {
                        when {
                            row.id.toLowerCase().contains(charSearch.toLowerCase()) -> {
                                resultList.add(row)
                            }
                            row.passanger_user.toLowerCase().contains(charSearch.toLowerCase()) -> {
                                resultList.add(row)
                            }
                            row.price.toString().toLowerCase().contains(charSearch.toLowerCase()) -> {
                                resultList.add(row)
                            }
                            row.discount.toString().toLowerCase().contains(charSearch.toLowerCase()) -> {
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
                itemsList = results?.values as ArrayList<Ticket>
                notifyDataSetChanged()
            }

        }
    }
}

