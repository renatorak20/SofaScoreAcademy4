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

            val demoCompanies = listOf(
                Company("Sofascore", "Vrbani 4", "Zagreb", "Croatia", "Zlatko Hrkac & Ivan Beslic", "marketing@sofascore.com",
                    "https://media.licdn.com/dms/image/C4D0BAQEFe9Kh-YDJ7w/company-logo_200_200/0/1669205795409?e=1686787200&v=beta&t=urJl2rwozSzfc0LQeviE7tz_O5WJSUfJ49WIY9VES7c",
                    "Sofascore has everything a sports fan needs – the fastest live score and superdetailed statistics for 23 sports.", 2010, Industry.Technology, "Private"),
                Company("Cinnamon", "Zagrebacka 5", "Zagreb", "Croatia", "Luka Lukic", "contactus@cinnamon.com",
                    "https://itjobscroatia.com/static/images/company/c7d87f7c-5e2c-4d69-853f-df024a2bf987.png",
                    "It's all about design.", 2009, Industry.Technology, "Private"),
                Company("Very Big Things", "Zadarska 13", "Zagreb", "Croatia", "Marko Maric", "letschat@vbt.com",
                    "https://itjobscroatia.com/static/images/company/f8cf0ec3-4271-459a-947e-0381b164e96e.png",
                    "We work on a lot of things.", 2008, Industry.Technology, "Private"),
                Company("Sofascore", "Vrbani 4", "Zagreb", "Croatia", "Zlatko Hrkac & Ivan Beslic", "marketing@sofascore.com",
                    "https://media.licdn.com/dms/image/C4D0BAQEFe9Kh-YDJ7w/company-logo_200_200/0/1669205795409?e=1686787200&v=beta&t=urJl2rwozSzfc0LQeviE7tz_O5WJSUfJ49WIY9VES7c",
                    "Sofascore has everything a sports fan needs – the fastest live score and superdetailed statistics for 23 sports.", 2010, Industry.Technology, "Private"),
                Company("Cinnamon", "Zagrebacka 5", "Zagreb", "Croatia", "Luka Lukic", "contactus@cinnamon.com",
                    "https://itjobscroatia.com/static/images/company/c7d87f7c-5e2c-4d69-853f-df024a2bf987.png",
                    "It's all about design.", 2009, Industry.Technology, "Private"),
                Company("Very Big Things", "Zadarska 13", "Zagreb", "Croatia", "Marko Maric", "letschat@vbt.com",
                    "https://itjobscroatia.com/static/images/company/f8cf0ec3-4271-459a-947e-0381b164e96e.png",
                    "We work on a lot of things.", 2008, Industry.Technology, "Private"),
                Company("Sofascore", "Vrbani 4", "Zagreb", "Croatia", "Zlatko Hrkac & Ivan Beslic", "marketing@sofascore.com",
                    "https://media.licdn.com/dms/image/C4D0BAQEFe9Kh-YDJ7w/company-logo_200_200/0/1669205795409?e=1686787200&v=beta&t=urJl2rwozSzfc0LQeviE7tz_O5WJSUfJ49WIY9VES7c",
                    "Sofascore has everything a sports fan needs – the fastest live score and superdetailed statistics for 23 sports.", 2010, Industry.Technology, "Private"),
                Company("Cinnamon", "Zagrebacka 5", "Zagreb", "Croatia", "Luka Lukic", "contactus@cinnamon.com",
                    "https://itjobscroatia.com/static/images/company/c7d87f7c-5e2c-4d69-853f-df024a2bf987.png",
                    "It's all about design.", 2009, Industry.Technology, "Private"),
                Company("Very Big Things", "Zadarska 13", "Zagreb", "Croatia", "Marko Maric", "letschat@vbt.com",
                    "https://itjobscroatia.com/static/images/company/f8cf0ec3-4271-459a-947e-0381b164e96e.png",
                    "We work on a lot of things.", 2008, Industry.Technology, "Private"),
                Company("Sofascore", "Vrbani 4", "Zagreb", "Croatia", "Zlatko Hrkac & Ivan Beslic", "marketing@sofascore.com",
                    "https://media.licdn.com/dms/image/C4D0BAQEFe9Kh-YDJ7w/company-logo_200_200/0/1669205795409?e=1686787200&v=beta&t=urJl2rwozSzfc0LQeviE7tz_O5WJSUfJ49WIY9VES7c",
                    "Sofascore has everything a sports fan needs – the fastest live score and superdetailed statistics for 23 sports.", 2010, Industry.Technology, "Private"),
                Company("Cinnamon", "Zagrebacka 5", "Zagreb", "Croatia", "Luka Lukic", "contactus@cinnamon.com",
                    "https://itjobscroatia.com/static/images/company/c7d87f7c-5e2c-4d69-853f-df024a2bf987.png",
                    "It's all about design.", 2009, Industry.Technology, "Private"),
                Company("Very Big Things", "Zadarska 13", "Zagreb", "Croatia", "Marko Maric", "letschat@vbt.com",
                    "https://itjobscroatia.com/static/images/company/f8cf0ec3-4271-459a-947e-0381b164e96e.png",
                    "We work on a lot of things.", 2008, Industry.Technology, "Private")
            )

            if(viewModel.companies.value!!.isEmpty()){
                for(comp in demoCompanies){
                    viewModel.addCompany(comp)
                }
            }else{
                viewModel.nukeViewModel()
            }
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

