package com.example.eduardmishchenkoapp.projects

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.eduardmishchenkoapp.databinding.FragmentProjectsBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

class ProjectsFragment : Fragment() {

    private lateinit var binding: FragmentProjectsBinding
    private val adapter = ProjectAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProjectsBinding.inflate(inflater)
        init()

        return binding.root
    }

    private fun init() = with(binding){
        projectRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        projectRecyclerView.adapter = adapter
//        clear data Prject
        adapter.clearProject()
        val jsonFileString = context?.let { readJson(it.applicationContext) }
        val gson = Gson()
        val listProjectType = object : TypeToken<List<Project>>() {}.type
        val projects: List<Project> = gson.fromJson(jsonFileString, listProjectType)
//        add items to data Project
        for (item in projects) adapter.addProject(item)

        adapter.setOnItemClickListener(object : ProjectAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                val intent = Intent(activity, ProjectActivity::class.java)
                intent.putExtra("position", position)
                startActivity(intent)
            }
        })
    }

    private fun readJson(context: Context, fileName: String = "projects.json"): String?{
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException){
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }
    companion object{
        @JvmStatic
        fun newInstance() = ProjectsFragment()
    }
}