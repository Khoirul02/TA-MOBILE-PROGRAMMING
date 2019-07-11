package com.huda.ta_mobile_programming.tampilan

import android.annotation.SuppressLint
import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.huda.ta_mobile_programming.R
import com.huda.ta_mobile_programming.data.lib.ApiService
import com.huda.ta_mobile_programming.data.lib.RetroConfig
import com.huda.ta_mobile_programming.data.model.profil.ProfilItem
import com.huda.ta_mobile_programming.helper.ConfigData
import kotlinx.android.synthetic.main.activity_detail_cari.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

@Suppress("UNCHECKED_CAST")
class DetailCariActivity : AppCompatActivity() {
    private var items: ArrayList<ProfilItem> = arrayListOf()
    private lateinit var npm:String
    private lateinit var key:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_cari)
        npm = intent.getStringExtra(ConfigData.BUNDLE_NPM)
        key = intent.getStringExtra(ConfigData.BUNDLE_KEY)

//        Toast.makeText(this, "" + npm + key, Toast.LENGTH_LONG).show()

        val apiService: ApiService = RetroConfig.provideApi()
        apiService.getDataCariPribadi(key, npm)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                items.clear()
                items = it.data as ArrayList<ProfilItem>
                for (i: Int in items.indices) {
                    Toast.makeText(this, "" + items.get(i).nama, Toast.LENGTH_LONG).show()
                    tvNamaProfil.text = items.get(i).nama
                    tvNpmProfil.text = items.get(i).npm
                    tvKodeKelas.text = items.get(i).kelas
                    tvKodeDosen.text = items.get(i).dosenWali
                    tvNikProfil.text = items.get(i).nik
                    tvKlhrProfil.text = items.get(i).ktlhr
                    tvTlhrProfil.text = items.get(i).tlhr
                    Glide.with(this).load("http://informatika.upgris.ac.id/mobile/image/" + items.get(i).foto)
                        .override(512, 512).error(R.drawable.ic_launcher_background).into(ivImageProfile)
                    tvTransportProfil.text = items.get(i).transpor
                    tvAlamatKostProfil.text = items.get(i).alamatKos
                    tvAlamatProfil.text = items.get(i).almt
                    tvEmailProfil.text = items.get(i).email
                    tvGolProfil.text = items.get(i).darah
                    tvTransportProfil.text = items.get(i).telp
                    tvAyahProfil.text= items.get(i).ayah
                    tvIbuProfil.text= items.get(i).ibu
                }


            }, {
                error("Error" + it.message)
            })
    }
}
