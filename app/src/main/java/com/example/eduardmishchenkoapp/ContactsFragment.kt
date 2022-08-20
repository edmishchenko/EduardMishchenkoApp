package com.example.eduardmishchenkoapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.eduardmishchenkoapp.databinding.FragmentContactsBinding
import com.google.android.gms.maps.MapView

class ContactsFragment : Fragment() {

    private lateinit var binding: FragmentContactsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentContactsBinding.inflate(inflater, container, false)



        return binding.root
    }

    companion object{
        @JvmStatic
        fun newIntance() = ContactsFragment()
    }
}