package com.renato.sofascoreacademy4.ui.fragments

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.renato.sofascoreacademy4.R
import com.renato.sofascoreacademy4.databinding.FragmentSettingsBinding
import com.renato.sofascoreacademy4.util.Preferences


class SettingsFragment : Fragment() {

    private lateinit var binding:FragmentSettingsBinding
    private lateinit var preferences: SharedPreferences

    private lateinit var extras:List<String>
    private lateinit var extrasLang:List<String>
    private lateinit var extrasThemes:List<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        preferences = requireActivity().getSharedPreferences(resources.getString(R.string.package_name), Context.MODE_PRIVATE)

        binding = FragmentSettingsBinding.inflate(layoutInflater)

        extras = resources.getStringArray(R.array.extra).toList()
        extrasLang = resources.getStringArray(R.array.languages).toList()
        extrasThemes = resources.getStringArray(R.array.themes).toList()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadAppPreferenes()
        binding.themeSwitch.setOnCheckedChangeListener{
                _, isChecked ->
            if(isChecked){
                preferences.edit().putString(extrasThemes[0], extrasThemes[2]).apply()
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }else{
                preferences.edit().putString(extrasThemes[0], extrasThemes[1]).apply()
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

        binding.languageSwitch.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                preferences.edit().putString(extrasLang[0], extrasLang[2]).apply()
            }else{
                preferences.edit().putString(extrasLang[0], extrasLang[1]).apply()
            }

            Preferences().setAppLocale(preferences.getString(extrasLang[0], extrasLang[1]).toString())
        }
    }


    fun loadAppPreferenes(){
        when(preferences.getString(extrasThemes[0], extras[1])){
            extras[1] -> {
                val currentNightMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
                binding.themeSwitch.isChecked = currentNightMode == Configuration.UI_MODE_NIGHT_YES
            }
            extrasThemes[2] -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                binding.themeSwitch.isChecked = true
            }
            else -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                binding.themeSwitch.isChecked = false
            }
        }

        when(preferences.getString(extrasLang[0], extras[1])){
            extrasLang[1] -> {
                binding.languageSwitch.isChecked = false
            }
            else -> {
                binding.languageSwitch.isChecked = true
            }
        }
    }
}