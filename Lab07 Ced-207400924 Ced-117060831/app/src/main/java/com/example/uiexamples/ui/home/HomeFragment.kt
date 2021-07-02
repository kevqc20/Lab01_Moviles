package com.example.uiexamples.ui.home

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.uiexamples.MenuExample
import com.example.uiexamples.Persona
import com.example.uiexamples.Personas
import com.example.uiexamples.R


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    //var jobs: Flights = Flights.INSTANCE


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)



        return root
    }

    override fun onStart() {
        super.onStart()


        val activity: MenuExample? = activity as MenuExample?
        val user: Persona? = activity?.getUser()

        var personas: Personas = Personas.instance

        val user_name: TextView? = view?.findViewById(R.id.pr_user_name)
        var password = getView()?.findViewById(R.id.pr_password) as? EditText
        var name = getView()?.findViewById(R.id.pr_name) as? EditText
        var lastname = getView()?.findViewById(R.id.pr_lastname) as? EditText
        var email = getView()?.findViewById(R.id.pr_email) as? EditText
        var address = getView()?.findViewById(R.id.pr_address) as? EditText
        var cellphone = getView()?.findViewById(R.id.pr_cellphone) as? EditText
        var workphone = getView()?.findViewById(R.id.pr_workphone) as? EditText
        var update = getView()?.findViewById(R.id.pr_button2) as? Button



        user_name?.setText(user?.user)
        password?.setText(user?.password)
        name?.setText(user?.name)
        lastname?.setText(user?.lastname)
        email?.setText(user?.email)
        address?.setText(user?.address)
        cellphone?.setText("" + user?.cellphone)
        workphone?.setText("" + user?.workphone)

        update?.setOnClickListener {

            val user_name2 = user_name?.text;
            val password2 = password?.text;
            val name2 = name?.text;
            val lastname2 = lastname?.text;
            val email2 = email?.text;
            val address2 = address?.text;
            val cellphone2 = cellphone?.text;
            val workphone2 = workphone?.text;

            var auxi = Persona(
                user_name2.toString(),
                password2.toString(),
                name2.toString(),
                lastname2.toString(),
                email2.toString(),
                address2.toString(),
                Integer.parseInt(cellphone2.toString()),
                Integer.parseInt(workphone2.toString())
            )

            personas.editPerson(
                auxi
            )

            activity?.setUser(auxi)


            Toast.makeText(activity, "Perfil actualizado.", Toast.LENGTH_SHORT)
                .show()

            val ft = requireFragmentManager().beginTransaction()
            if (Build.VERSION.SDK_INT >= 26) {
                ft.setReorderingAllowed(false)
            }
            ft.detach(this).attach(this).commit()
        }
    }


}