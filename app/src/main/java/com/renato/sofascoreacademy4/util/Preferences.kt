package com.renato.sofascoreacademy4.util

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat

class Preferences {

    fun loadPreference(activity:Activity){

        val preferences = activity.getSharedPreferences("com.renato.sofascoreacademy4", Context.MODE_PRIVATE)

        when(preferences.getString("theme", "none")){
            "dark" -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
            else -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

        when(preferences.getString("lang", "none")){
            "en" ->{
                setAppLocale("en")
            }
            "hr" ->{
                setAppLocale("hr")
            }
        }
    }

    fun setAppLocale(language: String) {
        val appLocale: LocaleListCompat = LocaleListCompat.forLanguageTags(language)
        AppCompatDelegate.setApplicationLocales(appLocale)
    }

}