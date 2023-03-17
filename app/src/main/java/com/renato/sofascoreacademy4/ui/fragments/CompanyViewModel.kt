package com.renato.sofascoreacademy4.ui.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.renato.sofascoreacademy4.entities.Company
import com.renato.sofascoreacademy4.entities.Industry

class CompanyViewModel : ViewModel() {
    private val _companies = MutableLiveData<List<Company>>()
    val companies : LiveData<List<Company>> = _companies

    private val demoCompanies = listOf(
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

    init {
        for(company in demoCompanies){
            //addCompany(company)
        }
    }

    fun addCompany(company: Company) {
        val list = companies.value?.toMutableList() ?: mutableListOf()
        list.add(company)
        _companies.value = list
    }

    fun getList(): MutableLiveData<List<Company>> {
        return _companies
    }
}
