package com.example.eduardmishchenkoapp.projects

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.eduardmishchenkoapp.R
import com.example.eduardmishchenkoapp.databinding.ActivityProjectBinding
import com.example.eduardmishchenkoapp.projects.rickandmorty.RickAndMortyFragment
import com.example.eduardmishchenkoapp.projects.torch.TorchFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProjectActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProjectBinding
    private val listOfProjectsFragment: MutableList<Fragment> = mutableListOf(
        TorchFragment.newInstance(),
        RickAndMortyFragment.newInstance()
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProjectBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar.toolbarMenu)
    }

    override fun onStart(): Unit = with(binding){
        super.onStart()
//        Button back on toolbar
        supportActionBar?.title = getString(R.string.app_name)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val position = intent.getIntExtra("position", 0)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.activity_project_place_holder, listOfProjectsFragment[position])
            .commit()
    }
}