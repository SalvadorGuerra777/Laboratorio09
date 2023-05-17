package com.example.laboratorio09

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.corutinesdemo.R
import com.example.corutinesdemo.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                onBackPressed()
            }
        })

        listeners()

    }

    private fun onBackPressed(){
        val navController = Navigation.findNavController(requireView())
        if(navController.currentDestination?.id != R.id.homeFragment){
            navController.popBackStack()
        }
        else{
            requireActivity().onBackPressed()
        }
    }
    private fun listeners(){
        binding.coroutinesButton.setOnClickListener{
            it.findNavController().navigate(R.id.action_homeFragment_to_coroutinesFragment)
        }

        binding.mainThreadButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_mainThreadFragment)
        }
    }
}