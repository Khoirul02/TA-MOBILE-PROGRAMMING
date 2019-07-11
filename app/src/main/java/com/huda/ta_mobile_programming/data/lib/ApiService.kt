package com.huda.ta_mobile_programming.data.lib

import com.huda.ta_mobile_programming.data.model.jadwal.ItemJadwal
import com.huda.ta_mobile_programming.data.model.profil.ItemProfil
import retrofit.http.GET
import retrofit.http.Query
import rx.Observable

interface ApiService {
    @GET("detil_pribadi?")
    fun getDataPribadi(
        @Query("key") key : String,
        @Query("npm") npm: String
    ): Observable<ItemProfil>

    @GET("detil_pribadi?")
    fun getDataCariPribadi(
        @Query("key") key : String,
        @Query("npm") npm: String
    ): Observable<ItemProfil>


    @GET("detil_jadwal?")
    fun getDetilJadwal(
        @Query("key") key : String,
        @Query("npm") npm: String
    ): Observable<ItemJadwal>

}