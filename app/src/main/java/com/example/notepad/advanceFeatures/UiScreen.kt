package com.example.notepad.advanceFeatures

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.notepad.R
import com.example.notepad.databinding.ActivityUiScreenBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

import android.view.Menu
import androidx.fragment.app.FragmentManager
import android.view.MenuInflater
import com.example.notepad.fragments.HomeFragment


class UiScreen : AppCompatActivity() {
    private lateinit var binding:ActivityUiScreenBinding
    val profilePicUrl =
        "https://instagram.fnag1-1.fna.fbcdn.net/vp/92a15d2c91d06d45f9a5b72ffd4cf3bd/5D84C9FD/t51.2885-19/s150x150/54731743_2011997322443409_3029283709959274496_n.jpg?_nc_ht=instagram.fnag1-1.fna.fbcdn.net"
    val images = arrayOf(
        profilePicUrl,
        "https://blog.rackspace.com/wp-content/uploads/2018/09/pumping-iron-arnold-schwarzenegger-1-1108x0-c-default.jpg",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSijnCjlpixxnEcvYeKm-1pg6s2ohuD2VMcMoIzTZInCSZ57SJN",
        "https://pbs.twimg.com/profile_images/798351849984294912/okhePpJW.jpg",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRhuaOnKGXWUAV7UMA9UhUQB66kaIne0HYKUDOgfzr8dCO2tchv"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding=DataBindingUtil. setContentView(this,R.layout.activity_ui_screen)
        setContent()
    }

    private fun setContent() {
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNav)

        loadFragment(HomeFragment()) //Default is home fragment


        bottomNavigationView.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> return@OnNavigationItemSelectedListener loadFragment(HomeFragment())
              //  R.id.search -> return@OnNavigationItemSelectedListener loadFragment(SearchFragment())
              //  R.id.notifications -> return@OnNavigationItemSelectedListener loadFragment(
                    //NotificationsFragment()
              //  )
              //  R.id.profile -> return@OnNavigationItemSelectedListener loadFragment(ProfileFragment())
            }
            false
        })
    }

    private fun loadFragment(fragment: Fragment): Boolean {
        if (fragment != null) {
            val fm: FragmentManager = supportFragmentManager
            fm.beginTransaction()
                .replace(com.example.notepad.R.id.container, fragment)
                .commit()
            return true
        }
        return false
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(com.example.notepad.R.menu.bottom_menu, menu)
        return true
    }
}