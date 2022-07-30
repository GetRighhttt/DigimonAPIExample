package com.example.stefanbaynefinalproject.fragment

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.stefanbaynefinalproject.databinding.FragmentAllDigimonBinding
import com.example.stefanbaynefinalproject.repository.DigimonRepositoryImpl
import com.example.stefanbaynefinalproject.adapter.AllDigimonAdapter
import com.example.stefanbaynefinalproject.viewmodel.DigimonViewModel
import com.example.stefanbaynefinalproject.factory.DigimonViewModelFactory

/**
 * This is the fragment which will display all the Digimon from the API.
 * Unfortunately, my API didn't have any details per each digimon besides name and level.
 */

class AllDigimon : androidx.fragment.app.Fragment() {

    // Initializing viewbinding variables
    private var _binding: FragmentAllDigimonBinding? = null
    val binding: FragmentAllDigimonBinding get() =  _binding!!

    // Will initialize adapters later on
    lateinit var allDigimonAdapter: AllDigimonAdapter
    private lateinit var viewModel: DigimonViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAllDigimonBinding.inflate(inflater, container, false)

        // Calling the viewModel to observe LiveData
        viewModel = ViewModelProvider(this,
            DigimonViewModelFactory(DigimonRepositoryImpl()))[DigimonViewModel::class.java]
        viewModel.digimonData.observe(viewLifecycleOwner, Observer { newListChange ->
            binding.pbTest.visibility = View.GONE
            if (newListChange.isEmpty()){
                binding.rvAll.adapter = AllDigimonAdapter(emptyList())
            }else{
                allDigimonAdapter = AllDigimonAdapter(newListChange)
                binding.rvAll.adapter = allDigimonAdapter
            }
        })

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}