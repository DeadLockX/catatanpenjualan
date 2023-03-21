package com.example.catatnpenjualan.utils

import java.text.NumberFormat
import java.util.Locale

object uang {
    fun indonesia(uang:Double):String{
        val localeId =Locale("in","ID")
        val kursId:NumberFormat=NumberFormat.getCurrencyInstance(localeId)

        return  kursId.format(uang)
    }
}