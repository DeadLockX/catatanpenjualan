package com.example.catatnpenjualan.activity.login

import com.example.catatnpenjualan.model.User

interface LoginView {
    fun onSuccessLogin(user: User?)
    fun onErrorLogin(msg:String?)
}