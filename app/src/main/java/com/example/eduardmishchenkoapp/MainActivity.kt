package com.example.eduardmishchenkoapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import android.view.View
//import android.content.Context
//import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.eduardmishchenkoapp.biography.BiographyFragment
import com.example.eduardmishchenkoapp.contacts.ContactsFragment
import com.example.eduardmishchenkoapp.databinding.ActivityMainBinding
import com.example.eduardmishchenkoapp.projects.ProjectsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val listOfMenuFragment: MutableList<Fragment> = mutableListOf(
        BiographyFragment.newInstance(),
        ProjectsFragment.newInstance(),
        ContactsFragment.newIntance())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar.toolbarMenu)
//        Set default fragment in main activity
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.place_holder, listOfMenuFragment[1])
            .commit()
    }

    override fun onStart() = with(binding){
        super.onStart()
//        Drawer menu settings
        val drawerToggle = object : ActionBarDrawerToggle(this@MainActivity, drawerLayout, toolbar.toolbarMenu, R.string.open_drawer, R.string.close_drawer){}

        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.isDrawerIndicatorEnabled = true
        drawerToggle.syncState()

        navigationView.setNavigationItemSelectedListener{
            when(it.itemId){
                 R.id.biography -> supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.place_holder, listOfMenuFragment[0])
                    .commit()
                R.id.project -> supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.place_holder, listOfMenuFragment[1])
                    .commit()
                R.id.contact -> supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.place_holder, listOfMenuFragment[2])
                    .commit()
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }

}