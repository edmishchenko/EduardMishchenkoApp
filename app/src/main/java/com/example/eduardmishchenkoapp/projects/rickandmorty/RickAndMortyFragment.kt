package com.example.eduardmishchenkoapp.projects.rickandmorty

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.eduardmishchenkoapp.databinding.FragmentRickAndMortyBinding
import com.example.eduardmishchenkoapp.projects.rickandmorty.adapter.RickAndMortyPagedAdapter
import com.example.eduardmishchenkoapp.projects.rickandmorty.viewmodel.RickAndMortyViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import kotlinx.coroutines.launch

@WithFragmentBindings
@AndroidEntryPoint
class RickAndMortyFragment : Fragment() {

    private lateinit var binding: FragmentRickAndMortyBinding
    private lateinit var mAdapter: RickAndMortyPagedAdapter
    private val viewModel: RickAndMortyViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRickAndMortyBinding.inflate(inflater)
        setupRv()
        loadingData()
        return binding.root
    }

    private fun loadingData() {
        lifecycleScope.launch {
            viewModel.listData.collect{ pagingData ->
                mAdapter.submitData(pagingData)
            }
        }
    }

    private fun setupRv() {
        mAdapter = RickAndMortyPagedAdapter()
        binding.rickAndMortyPlaceHolder.apply {
            layoutManager = StaggeredGridLayoutManager(
                1, StaggeredGridLayoutManager.VERTICAL
            )
            adapter = mAdapter
            setHasFixedSize(true)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = RickAndMortyFragment()
    }
}