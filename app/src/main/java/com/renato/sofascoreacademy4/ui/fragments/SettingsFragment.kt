package com.renato.sofascoreacademy4.ui.fragments

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import androidx.fragment.app.Fragment
import com.renato.sofascoreacademy4.MainActivity
import com.renato.sofascoreacademy4.databinding.FragmentSettingsBinding
import java.util.*


class SettingsFragment : Fragment() {

    private lateinit var binding:FragmentSettingsBinding
    private lateinit var preferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        preferences = requireActivity().getSharedPreferences("com.renato.sofascoreacademy4", Context.MODE_PRIVATE)

        binding = FragmentSettingsBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadAppPreferenes()
        binding.themeSwitch.setOnCheckedChangeListener{
                _, isChecked ->
            if(isChecked){
                preferences.edit().putString("theme", "dark").apply()
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }else{
                preferences.edit().putString("theme", "light").apply()
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

        binding.languageSwitch.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                preferences.edit().putString("lang", "hr").apply()
            }else{
                preferences.edit().putString("lang", "en").apply()
            }

            setAppLocale(preferences.getString("lang", "en").toString())
        }
    }


    fun loadAppPreferenes(){
        when(preferences.getString("theme", "none")){
            "none" -> {
                val currentNightMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
                binding.themeSwitch.isChecked = currentNightMode == Configuration.UI_MODE_NIGHT_YES
            }
            "dark" -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                binding.themeSwitch.isChecked = true
            }
            else -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                binding.themeSwitch.isChecked = false
            }
        }

        when(preferences.getString("lang", "none")){
            "en" -> {
                binding.languageSwitch.isChecked = false
            }
            else -> {
                binding.languageSwitch.isChecked = true
            }
        }
    }

    fun setAppLocale(language: String) {
        val appLocale: LocaleListCompat = LocaleListCompat.forLanguageTags(language)
        AppCompatDelegate.setApplicationLocales(appLocale)
    }
}