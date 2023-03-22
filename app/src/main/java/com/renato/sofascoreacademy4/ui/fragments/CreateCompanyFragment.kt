package com.renato.sofascoreacademy4.ui.fragments

import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.children
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.renato.sofascoreacademy4.R
import com.renato.sofascoreacademy4.databinding.FragmentCreateCompanyBinding
import com.renato.sofascoreacademy4.entities.Company
import com.renato.sofascoreacademy4.entities.Industry
import com.renato.sofascoreacademy4.ui.customElements.CustomEditText

class CreateCompanyFragment : Fragment() {

    private lateinit var viewModel: CompanyViewModel

    private lateinit var constraintLayout: ConstraintLayout
    private lateinit var spinnerAdapter: ArrayAdapter<String>


    private lateinit var binding: FragmentCreateCompanyBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentCreateCompanyBinding.inflate(inflater, container, false)

        constraintLayout = binding.constraintLayout

        viewModel = ViewModelProvider(requireActivity())[CompanyViewModel::class.java]


        spinnerAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, arrayOf(getString(R.string.healthcare), getString(R.string.technology), getString(R.string.finance), getString(R.string.retail), getString(R.string.other)))
        binding.spinner.adapter = spinnerAdapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            addCompany()
        }

        binding.fillEmptyButton.setOnClickListener{
            viewModel.fillOrDestroy()
        }
    }

    private fun addCompany(){
        if (constraintLayout.areAllFieldsValid()) {
            val company = Company(
                binding.nameField.getText(),
                binding.addressField.getText(),
                binding.cityField.getText(),
                binding.countryField.getText(),
                binding.founderField.getText(),
                binding.emailField.getText(),
                binding.websiteField.getText(),
                binding.descriptionField.getText(),
                binding.foundationField.getText().toInt(),
                Industry.values()[binding.spinner.selectedItemPosition],
                getRadioSelectedValue())

            viewModel.addCompany(company)

            Toast.makeText(context, getString(R.string.success_message), Toast.LENGTH_SHORT).show()

            constraintLayout.resetFields()
        }
    }

    private fun getRadioSelectedValue() : String{
        val type =
            when(binding.radioGroup.radioGroup.checkedRadioButtonId){
                R.id.company_public -> getString(R.string.company_public)
                else -> getString(R.string.company_private)
            }
        return type
    }

    private fun ConstraintLayout.areAllFieldsValid(): Boolean {
        this.children.filterIsInstance<CustomEditText>().forEach {
            if (!it.isValid()) {
                return false
            }
        }
        return true
    }

    private fun ConstraintLayout.resetFields() {
        this.children.filterIsInstance<CustomEditText>().forEach {
            it.clear()
        }
    }
}

