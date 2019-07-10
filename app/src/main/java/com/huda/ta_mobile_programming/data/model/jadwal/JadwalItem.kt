package com.huda.ta_mobile_programming.data.model.jadwal

import com.google.gson.annotations.SerializedName

data class JadwalItem(

	@field:SerializedName("hari")
	val hari: String? = null,

	@field:SerializedName("nama_mki")
	val namaMki: String? = null,

	@field:SerializedName("kode_kelas")
	val kodeKelas: String? = null,

	@field:SerializedName("nama_dosen")
	val namaDosen: String? = null,

	@field:SerializedName("sks1")
	val sks1: String? = null,

	@field:SerializedName("kode_jadwal")
	val kodeJadwal: String? = null,

	@field:SerializedName("nama_mk")
	val namaMk: String? = null,

	@field:SerializedName("waktu")
	val waktu: String? = null,

	@field:SerializedName("kode_dosen2")
	val kodeDosen2: String? = null,

	@field:SerializedName("kode_mk")
	val kodeMk: String? = null,

	@field:SerializedName("kode_dosen1")
	val kodeDosen1: String? = null,

	@field:SerializedName("nama_ruang")
	val namaRuang: String? = null
)