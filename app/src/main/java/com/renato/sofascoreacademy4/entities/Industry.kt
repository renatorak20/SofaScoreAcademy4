package com.renato.sofascoreacademy4.entities

import android.content.res.Resources
import com.renato.sofascoreacademy4.R

enum class Industry(val stringRes: Int) {
    Healthcare(R.string.healthcare),
    Technology(R.string.technology),
    Finance(R.string.finance),
    Retail(R.string.retail),
    Other(R.string.other);
}