package com.example.eduardmishchenkoapp.projects.rickandmorty.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.eduardmishchenkoapp.databinding.RickAndMortyLayoutBinding
import com.example.eduardmishchenkoapp.projects.rickandmorty.models.RickAndMorty

class RickAndMortyPagedAdapter: PagingDataAdapter<RickAndMorty, RickAndMortyPagedAdapter.MyViewHolder>(diffCallback) {

    inner class MyViewHolder(val binding: RickAndMortyLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<RickAndMorty>() {
            override fun areItemsTheSame(oldItem: RickAndMorty, newItem: RickAndMorty): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: RickAndMorty, newItem: RickAndMorty): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = getItem(position)

        holder.binding.apply {
            rickAndMortyName.text = "${currentItem?.name}"
            rickAndMortySpecies.text = "${currentItem?.species}"
            rickAndMortyGender.text = "${currentItem?.gender}"

            val imageLink = currentItem?.image
            rickAndMortyImageView.load(imageLink){
                crossfade(true)
                crossfade(1000 )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(RickAndMortyLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
}