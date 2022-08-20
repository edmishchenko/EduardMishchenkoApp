package com.example.eduardmishchenkoapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.example.eduardmishchenkoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setSupportActionBar(binding.toolbar.toolbarMenu)
        //      Drawer menu settings
        val drawerToggle = object : ActionBarDrawerToggle(this, binding.drawerLayout, binding.toolbar.toolbarMenu, R.string.open_drawer, R.string.close_drawer)
        {
            override fun onDrawerClosed(view: View){
                super.onDrawerClosed(view)
                //toast("Drawer closed")
            }

            override fun onDrawerOpened(drawerView: View){
                super.onDrawerOpened(drawerView)
                //toast("Drawer opened")
            }
        }
        binding.drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.isDrawerIndicatorEnabled = true
        drawerToggle.syncState()

        binding.navigationView.setNavigationItemSelectedListener{
            when(it.itemId){
                R.id.biography -> supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.place_holder, Biography_fragment.newInstance())
                    .commit()
                R.id.project -> supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.place_holder, ProjectsFragment.newInstance())
                    .commit()
                R.id.contact -> supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.place_holder, ContactsFragment.newIntance())
                    .commit()
            }
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }

    private fun Context.toast(s: String){
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }

}