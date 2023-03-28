package com.renato.sofascoreacademy4.util

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import com.renato.sofascoreacademy4.R

class Preferences {


    fun loadPreference(activity:Activity){

        val resources = activity.resources
        val extras = resources.getStringArray(R.array.extra)
        val extrasLang = resources.getStringArray(R.array.languages)
        val extrasThemes = resources.getStringArray(R.array.themes)

        val preferences = activity.getSharedPreferences(resources.getString(R.string.package_name), Context.MODE_PRIVATE)

        when(preferences.getString(extrasThemes[0], extras[1])){
            extrasThemes[2] -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
            else -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

        when(preferences.getString(extrasLang[0], extras[1])){
            extrasLang[1] ->{
                setAppLocale(extrasLang[1])
            }
            extrasLang[2] ->{
                setAppLocale(extrasLang[2])
            }
        }
    }

    fun setAppLocale(language: String) {
        val appLocale: LocaleListCompat = LocaleListCompat.forLanguageTags(language)
        AppCompatDelegate.setApplicationLocales(appLocale)
    }

}