package com.renato.sofascoreacademy4.ui.fragments

import android.opengl.Visibility
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.renato.sofascoreacademy4.R
import com.renato.sofascoreacademy4.adapters.CompanyRecyclerAdapter
import com.renato.sofascoreacademy4.databinding.FragmentShowCompaniesBinding
import com.renato.sofascoreacademy4.entities.Company

class ShowCompaniesFragment : Fragment() {

    private lateinit var viewModel: CompanyViewModel
    private lateinit var binding: FragmentShowCompaniesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(requireActivity())[CompanyViewModel::class.java]

        binding = FragmentShowCompaniesBinding.inflate(inflater, container, false)

        binding.recyclerView.adapter = CompanyRecyclerAdapter(requireContext(),
            (viewModel.companies.value ?: arrayListOf()) as ArrayList<Company>
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.visibility = View.GONE

        viewModel.getList().observe(viewLifecycleOwner) {
            binding.recyclerView.adapter = CompanyRecyclerAdapter(requireContext(),
                (viewModel.companies.value as ArrayList<Company>)
            )
            if(viewModel.getList().value!!.isNotEmpty()){
                binding.recyclerView.visibility = View.VISIBLE
                binding.animationView.visibility = View.GONE
            }
        }

        binding.animationView.setOnClickListener{
            Snackbar.make(binding.root.rootView, resources.getString(R.string.companies_empty), Snackbar.LENGTH_SHORT).show()
        }


    }
}
