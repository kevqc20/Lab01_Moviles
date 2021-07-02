package com.example.uiexamples

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {

    var personas: Personas = Personas.instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        var re_user_name = findViewById(R.id.re_user) as EditText
        var re_password = findViewById(R.id.re_password) as EditText
        var re_name = findViewById(R.id.re_name) as EditText
        var re_lastname = findViewById(R.id.re_lastname) as EditText
        var re_email = findViewById(R.id.re_email) as EditText
        var re_address = findViewById(R.id.re_address) as EditText
        var re_cellphone = findViewById(R.id.re_cellphone) as EditText
        var re_workphone = findViewById(R.id.re_workphone) as EditText


        var btn_submit = findViewById(R.id.re_button2) as Button

        // set on-click listener
        btn_submit.setOnClickListener {

            val user_name = re_user_name.text;
            val password = re_password.text;
            val name = re_name.text;
            val lastname = re_lastname.text;
            val email = re_email.text;
            val address = re_address.text;
            val cellphone = re_cellphone.text;
            val workphone = re_workphone.text;



            //Toast.makeText(this@LoginExample, user_name, Toast.LENGTH_LONG).show()
            if(personas.addPersona(Persona(user_name.toString(), password.toString(), name.toString(), lastname.toString(), email.toString(), address.toString(), Integer.parseInt(cellphone.toString()), Integer.parseInt(workphone.toString())))){
                Toast.makeText(this, "Usuario registrado satisfactoriamente.", Toast.LENGTH_SHORT).show()
                finish()
                // your code to validate the user_name and password combination
                // and verify the same
            }else{
                Toast.makeText(this, "Error, por favor revise los datos.", Toast.LENGTH_SHORT).show()
            }


        }

    }
}