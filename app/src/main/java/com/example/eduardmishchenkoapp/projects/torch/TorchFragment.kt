package com.example.eduardmishchenkoapp.projects.torch

import android.content.Context
import android.hardware.camera2.CameraManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.eduardmishchenkoapp.R
import com.example.eduardmishchenkoapp.databinding.FragmentTorchBinding

class TorchFragment : Fragment() {

    private lateinit var binding: FragmentTorchBinding
    private lateinit var cameraID: String
    private var button_status: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTorchBinding.inflate(inflater)
        init()
        return binding.root
    }

    private fun init() = with(binding){
        val cameraManager: CameraManager = activity?.getSystemService(Context.CAMERA_SERVICE) as CameraManager

        try {
            cameraID = cameraManager.cameraIdList[0]
        }catch (e: Exception){ e.printStackTrace() }

        torchFragmentButtonTorch.setOnClickListener{
            if (!button_status){
                try {
                    button_status = true
                    cameraManager.setTorchMode(cameraID, true)
                    torchFragmentButtonTorch.setImageResource(R.drawable.torch_on)
                }catch (e: Exception) { e.printStackTrace() }
            }else {
                try {
                    cameraManager.setTorchMode(cameraID, false)
                    button_status = false
                    torchFragmentButtonTorch.setImageResource(R.drawable.torch_off)
                }catch (e: Exception) { e.printStackTrace() }
            }
        }
    }

    companion object{
        @JvmStatic
        fun newInstance() = TorchFragment()
    }
}