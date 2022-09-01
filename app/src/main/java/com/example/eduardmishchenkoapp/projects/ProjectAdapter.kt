package com.example.eduardmishchenkoapp.projects

import android.annotation.SuppressLint
import android.text.SpannableStringBuilder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.bold
import androidx.recyclerview.widget.RecyclerView
import com.example.eduardmishchenkoapp.R
import com.example.eduardmishchenkoapp.databinding.ProjectItemBinding

class ProjectAdapter: RecyclerView.Adapter<ProjectAdapter.ProjectHolder>(){
    private val projectList = ArrayList<Project>()
    private lateinit var mListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener){
        mListener = listener
    }

    class ProjectHolder(item: View, listener: OnItemClickListener): RecyclerView.ViewHolder(item){
        private val binding = ProjectItemBinding.bind(item)

        @SuppressLint("SetTextI18n")
        fun bind(project: Project) = with(binding){
            projectTitle.text = project.title
            val technology = SpannableStringBuilder()
                .bold { append("Technology: ") }
                .append(project.technology)
            projectTechnologyValue.text = technology
        }

        init {
            item.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.project_item, parent, false)
        return ProjectHolder(view, mListener)
    }

    override fun onBindViewHolder(holder: ProjectHolder, position: Int) {
        holder.bind(projectList[position])
    }

    override fun getItemCount(): Int {
        return projectList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addProject(project: Project){
        projectList.add(project)
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun clearProject(){
        projectList.clear()
        notifyDataSetChanged()
    }

}