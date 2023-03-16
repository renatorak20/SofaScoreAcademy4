package com.renato.sofascoreacademy4.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.renato.sofascoreacademy4.R
import com.renato.sofascoreacademy4.databinding.FragmentShowCompaniesBinding
import com.renato.sofascoreacademy4.entities.Company

class ShowCompaniesFragment : Fragment() {

    private lateinit var viewModel: CompanyViewModel
    private lateinit var listView: ListView
    private lateinit var binding: FragmentShowCompaniesBinding
    private lateinit var adapter:ArrayAdapter<Company>
    private lateinit var recyclerView:RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(requireActivity())[CompanyViewModel::class.java]

        binding = FragmentShowCompaniesBinding.inflate(inflater, container, false)
        recyclerView = binding.recyclerView

        //adapter = ArrayAdapter(requireContext(), R.layout.company_object, viewModel.companies.value ?: mutableListOf())


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getList().observe(viewLifecycleOwner) {
            //adapter = ArrayAdapter(requireContext(), R.layout.company_object, viewModel.companies.value ?: mutableListOf())
            //listView.adapter = adapter
        }
    }
}
