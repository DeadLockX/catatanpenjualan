package com.example.catatnpenjualan.activity.login

import com.example.catatnpenjualan.model.User
import com.google.gson.annotations.SerializedName

data class ResultLogin(

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("user")
	val user: User? = null,

	@field:SerializedName("status")
	val status: String? = null
)