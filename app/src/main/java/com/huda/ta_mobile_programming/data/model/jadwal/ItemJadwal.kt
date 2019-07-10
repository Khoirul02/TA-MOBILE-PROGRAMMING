package com.huda.ta_mobile_programming.data.model.jadwal

import com.google.gson.annotations.SerializedName

data class ItemJadwal(

	@field:SerializedName("data")
	val data: List<JadwalItem?>? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("error")
	val error: Boolean? = null
)