package com.huda.ta_mobile_programming.tampilan

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.huda.ta_mobile_programming.R
import kotlinx.android.synthetic.main.activity_detail_jadwal_kuliah.*

class DetailJadwalKuliahActivity : AppCompatActivity() {
   lateinit var kodeJadwal:String
   lateinit var kodeKelas:String
   lateinit var kodeMk:String
   lateinit var namaDosen:String
   lateinit var kodeDosen1:String
   lateinit var kodeDosen2:String
   lateinit var sks1:String
   lateinit var namaRuang:String
//   lateinit var hari:String
   lateinit var waktu:String
   lateinit var namaMk:String
   lateinit var namaMki:String
    var namaHari: String? = null
    var namaHariServer: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_jadwal_kuliah)
        namaHariServer = intent.getStringExtra("HARI")
        if (namaHariServer!!.equals("1")) {
            namaHari = "Senin"
        } else if (namaHariServer!!.equals("2")) {
            namaHari = "Selasa"
        } else if (namaHariServer!!.equals("3")) {
            namaHari = "Rabu"
        } else if (namaHariServer!!.equals("4")) {
            namaHari = "Kamis"
        } else if (namaHariServer!!.equals("5")) {
            namaHari = "Jum'at"
        } else if (namaHariServer!!.equals("6")) {
            namaHari = "Sabtu"
        } else if (namaHariServer!!.equals("7")) {
            namaHari = "Minggu"
        }
        kodeJadwal = intent.getStringExtra("KODEJADWAL")
        kodeKelas = intent.getStringExtra("KODEKELAS")
        kodeMk = intent.getStringExtra("KODEMK")
        namaDosen = intent.getStringExtra("NAMADOSEN")
        kodeDosen1 = intent.getStringExtra("KODEDOSEN1")
        kodeDosen2 = intent.getStringExtra("KODEDOSEN2")
        sks1 = intent.getStringExtra("SKS1")
        namaRuang = intent.getStringExtra("NAMARUANG")
//        hari = intent.getStringExtra("HARI")
        waktu = intent.getStringExtra("WAKTU")
        namaMk = intent.getStringExtra("NAMAMAKUL")
        namaMki = intent.getStringExtra("NAMAMAKULBAHASAASING")

        tvKodeJadwalMK.text= kodeJadwal
        tvKodeKelas.text= kodeKelas
        tvKodeMK.text= kodeMk
        tvNamaDosenMK.text= namaDosen
        tvKodeDosen1.text= kodeDosen1
        tvKodeDosen2.text= kodeDosen2
        tvSksMK.text= sks1
        tvRuangMK.text= namaRuang
        tvHariMK.text= namaHari
        tvWaktuMK.text= waktu
        tvNamaMK.text = namaMk

    }
}
