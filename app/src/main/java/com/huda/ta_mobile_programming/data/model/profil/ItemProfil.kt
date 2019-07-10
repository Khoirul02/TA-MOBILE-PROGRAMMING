package com.huda.ta_mobile_programming.data.model.profil

import com.google.gson.annotations.SerializedName

data class ItemProfil(

    @field:SerializedName("data")
	val data: List<ProfilItem?>? = null,

    @field:SerializedName("id")
	val id: Int? = null,

    @field:SerializedName("error")
	val error: Boolean? = null
)