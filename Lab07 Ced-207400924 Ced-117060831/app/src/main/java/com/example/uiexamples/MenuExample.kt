package com.example.uiexamples


import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.uiexamples.ui.home.HomeFragment
import com.google.android.material.navigation.NavigationView


class MenuExample : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener  {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var homeFragment: HomeFragment
    private lateinit var user: Persona

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_example)

        val bundle = intent.extras
        val msg = bundle!!.getString("msg")
        user =  bundle.getSerializable("Login") as Persona

        if (msg != null) {
            Toast.makeText(this, "$msg ${user.name} ${user.password}", Toast.LENGTH_SHORT).show()
        }

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        navView.setNavigationItemSelectedListener(this)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_example, menu)
        return true
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId){
            R.id.nav_home -> {
                homeFragment = HomeFragment()
                supportFragmentManager
                    .beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .replace(R.id.nav_host_fragment, homeFragment)
                    .addToBackStack(null)
                    .commit()
            }
            R.id.nav_tickets -> {

                val i = Intent(this, CrudTickets::class.java)
                i.putExtra("user", this.getUser().user)
                startActivity(i)
            }
            R.id.nav_flights -> {
                val i = Intent(this, GetFlights::class.java)
                i.putExtra("user", this.getUser())
                startActivity(i)
            }
            R.id.nav_logout -> {
                val i = Intent(this, LoginExample::class.java)
                startActivity(i)
            }
        }
        return true
    }
    override fun onBackPressed() {
        val fragments = supportFragmentManager.backStackEntryCount
        if (fragments == 1) {
            finish()
            return
        }
        super.onBackPressed()
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }



    fun getUser() : Persona {
        return user
    }

    fun setUser(p : Persona){
        this.user = p
    }
}

