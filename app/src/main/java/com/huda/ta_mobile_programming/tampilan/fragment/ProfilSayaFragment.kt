package com.huda.ta_mobile_programming.tampilan.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bumptech.glide.Glide
import com.huda.ta_mobile_programming.R
import com.huda.ta_mobile_programming.data.lib.ApiService
import com.huda.ta_mobile_programming.data.lib.RetroConfig
import com.huda.ta_mobile_programming.data.model.profil.ProfilItem
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.fragment_profil_saya.view.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

@Suppress("UNCHECKED_CAST")
class ProfilSayaFragment : Fragment() {
    //variable
    private var items: ArrayList<ProfilItem> = arrayListOf()
    private lateinit var tvNamaProfil: TextView
    private lateinit var tvNpmProfil: TextView
    private lateinit var tvKodeDosenProfil: TextView
    private lateinit var tvKodeKelasProfil: TextView
    private lateinit var tvNikProfil: TextView
    private lateinit var tvTlhrProfil: TextView
    private lateinit var tvKhrProfil: TextView
    private lateinit var tvTransportasiProfil: TextView
    private lateinit var tvEmailProfil: TextView
    private lateinit var tvGolProfil: TextView
    private lateinit var tvAlamatProfil: TextView
    private lateinit var tvNoTelephoneProfil: TextView
    private lateinit var tvAyahProfil: TextView
    private lateinit var tvIbuProfil: TextView
    private lateinit var tvAlamatKostProfil: TextView
    private lateinit var ivImageProfile: CircleImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_profil_saya, container, false)
        ivImageProfile = view.ivImageProfile
        tvNamaProfil = view.tvNamaProfil
        tvNpmProfil = view.tvNpmProfil
        tvKodeDosenProfil = view.tvKodeDosen
        tvKodeKelasProfil = view.tvKodeKelas
        tvNikProfil = view.tvNikProfil
        tvKhrProfil = view.tvKlhrProfil
        tvTlhrProfil = view.tvTlhrProfil
        tvTransportasiProfil = view.tvTransportProfil
        tvAlamatKostProfil = view.tvAlamatKostProfil
        tvAlamatProfil = view.tvAlamatProfil
        tvEmailProfil = view.tvEmailProfil
        tvGolProfil = view.tvGolProfil
        tvNoTelephoneProfil = view.tvNoTlphonProfil
        tvAyahProfil = view.tvAyahProfil
        tvIbuProfil = view.tvIbuProfil

        getDataProfil()

        return view;
    }
    private fun getDataProfil(){
        val apiService: ApiService = RetroConfig.provideApi()
        apiService.getDataPribadi("f7bd80b1324690c3f15dc6a5cab3e1","16670023")
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                items.clear()
                items = it.data as ArrayList<ProfilItem>
                for (i: Int in items.indices) {
                    tvNamaProfil.text = items.get(i).nama
                    tvNpmProfil.text = items.get(i).npm
                    tvKodeKelasProfil.text = items.get(i).kelas
                    tvKodeDosenProfil.text = items.get(i).dosenWali
                    activity?.let { it1 ->
                        Glide.with(it1).load("http://informatika.upgris.ac.id/mobile/image/" + items.get(i).foto)
                            .override(512, 512).error(R.drawable.ic_launcher_background).into(ivImageProfile)
                    }
                    tvNikProfil.text = items.get(i).nik
                    tvKhrProfil.text = items.get(i).ktlhr
                    tvTlhrProfil.text = items.get(i).tlhr
                    tvTransportasiProfil.text = items.get(i).transpor
                    tvAlamatKostProfil.text = items.get(i).alamatKos
                    tvAlamatProfil.text = items.get(i).almt
                    tvEmailProfil.text = items.get(i).email
                    tvGolProfil.text = items.get(i).darah
                    tvNoTelephoneProfil.text = items.get(i).telp
                    tvAyahProfil.text= items.get(i).ayah
                    tvIbuProfil.text= items.get(i).ibu
                }


            }, {
                error("Error" + it.message)
            })
    }

}
