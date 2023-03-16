package com.renato.sofascoreacademy4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.load
import coil.transform.CircleCropTransformation
import com.google.android.material.snackbar.Snackbar
import com.renato.sofascoreacademy4.databinding.ActivityScrollingBinding
import com.renato.sofascoreacademy4.entities.Company

class ScrollingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScrollingBinding
    private lateinit var company:Company

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        company = intent.getSerializableExtra("extra") as Company

        binding.fab.setOnClickListener {
            finish()
        }

        binding.companyImage.load(company.website){
            transformations(CircleCropTransformation())
            placeholder(R.drawable.elon_musk)
        }
        setText()

    }

    private fun setText(){
        binding.contentScrolling.nameText?.text = company.name
        binding.contentScrolling.addressText?.text = company.address
        binding.contentScrolling.cityText?.text = company.city
        binding.contentScrolling.countryText?.text = company.country
        binding.contentScrolling.founderText?.text = company.founder
        binding.contentScrolling.emailText?.text = company.email
        binding.contentScrolling.websiteText?.text = company.website
        binding.contentScrolling.descriptionText?.text = company.description
        binding.contentScrolling.yearFoundedText?.text = company.yearFounded.toString()
        binding.contentScrolling.industryText?.text = company.industry.toString()
        binding.contentScrolling.typeText?.text = company.type
    }


}