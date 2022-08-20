package com.example.eduardmishchenkoapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.eduardmishchenkoapp.databinding.FragmentBiographyFragmentBinding

class Biography_fragment : Fragment() {

    private lateinit var binding: FragmentBiographyFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBiographyFragmentBinding.inflate(inflater)
        return binding.root
    }

    companion object{
        @JvmStatic
        fun newInstance() = Biography_fragment()
    }
}