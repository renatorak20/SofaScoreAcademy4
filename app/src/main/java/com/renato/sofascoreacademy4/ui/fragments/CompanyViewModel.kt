package com.renato.sofascoreacademy4.ui.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.renato.sofascoreacademy4.entities.Company
import com.renato.sofascoreacademy4.entities.Industry

class CompanyViewModel : ViewModel() {
    private val _companies = MutableLiveData<List<Company>>()
    val companies : LiveData<List<Company>> = _companies

    init {
        _companies.value = mutableListOf()
    }

    fun addCompany(company: Company) {
        val list = companies.value?.toMutableList() ?: mutableListOf()
        list.add(company)
        _companies.value = list
    }

    fun addCompanies(companies: List<Company>){
        _companies.value = companies
    }

    fun getList(): MutableLiveData<List<Company>> {
        return _companies
    }

    fun nukeViewModel(){
        _companies.value = mutableListOf()
    }
}
