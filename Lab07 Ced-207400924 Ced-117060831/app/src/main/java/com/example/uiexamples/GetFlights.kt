package com.example.uiexamples

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.android.material.navigation.NavigationView

class GetFlights : AppCompatActivity() {
    private lateinit var user: Persona

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_flights)

        val spinnerOrigen = findViewById<Spinner>(R.id.get_origin)
        val spinnerDestino = findViewById<Spinner>(R.id.get_destino)
        val spinnerTipo = findViewById<Spinner>(R.id.get_tipo)
        val dateR = findViewById<DatePicker>(R.id.datePickerRetorno)
        val dateRText = findViewById<TextView>(R.id.re_register7)
        val dateS = findViewById<DatePicker>(R.id.datePickerSalida)
        val get_flightB = findViewById<Button>(R.id.get_flightB)


        spinnerTipo?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                if(spinnerTipo.selectedItem == "Solo ida"){
                    dateR.visibility = View.INVISIBLE
                    dateRText.visibility = View.INVISIBLE
                } else {
                    dateR.visibility = View.VISIBLE
                    dateRText.visibility = View.VISIBLE
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                /*Do something if nothing selected*/
            }
        }

        get_flightB?.setOnClickListener {
            var iorigen = spinnerOrigen?.selectedItem.toString()
            var idestino = spinnerDestino?.selectedItem.toString()
            var imonthS = dateS?.month?.plus(1)
            var idayS = dateS?.dayOfMonth?.minus(1)
            var iyearS = dateS?.year?.minus(1)
            var idateS = "" + idayS + "-" + imonthS + "-" + iyearS
            var idateR = ""
            if(dateR.visibility == View.VISIBLE){
                var imonthR = dateR?.month?.plus(1)
                var idayR = dateR?.dayOfMonth?.minus(1)
                var iyearR = dateR?.year?.minus(1)
                idateR = "" + idayR + "-" + imonthR + "-" + iyearR
            }

            val i = Intent(this, CrudFlights::class.java)
            i.putExtra("Origen", iorigen)
            i.putExtra("Destino", idestino)
            i.putExtra("FechaS", idateS)
            if(dateR.visibility == View.VISIBLE){
                i.putExtra("FechaR", idateR)
            }

            val bundle = intent.extras
            user =  bundle?.getSerializable("user") as Persona

            i.putExtra("user", user)
            startActivity(i)
        }


    }
}