package com.huda.ta_mobile_programming.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.huda.ta_mobile_programming.R
import com.huda.ta_mobile_programming.data.model.jadwal.JadwalItem
import com.huda.ta_mobile_programming.tampilan.DetailJadwalKuliahActivity
import kotlinx.android.synthetic.main.list_jadwal_kuliah.view.*

class JadwalKuliahAdapter : RecyclerView.Adapter<JadwalKuliahAdapter.ViewHolder> {
    var namaHari: String? = null
    var namaHariServer: String? = null
    private lateinit var context: Context
    private var items: ArrayList<JadwalItem>? = null
    private var orig: ArrayList<JadwalItem>? = null

    constructor(context: Context?, items: ArrayList<JadwalItem>) : this() {
        this.context = context!!
        this.items = items
        this.orig = items
    }
    constructor()

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int) =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_jadwal_kuliah, p0, false))

    override fun getItemCount(): Int = items?.size as Int
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.namaMataKuliahJadwal.text = items?.get(position)?.namaMk
        holder.namaDosenMataKuliahJadwal.text = items?.get(position)?.namaDosen
        namaHariServer = items?.get(position)?.hari
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
        holder.namaHariJadwal.text = namaHari + ","+ items?.get(position)?.waktu + ","+ items?.get(position)?.namaRuang
        holder.detailJadwal.setOnClickListener {
            val intent: Intent = Intent(context, DetailJadwalKuliahActivity::class.java)
            intent.putExtra("KODEJADWAL", items?.get(position)?.kodeJadwal)
            intent.putExtra("KODEKELAS", items?.get(position)?.kodeKelas)
            intent.putExtra("KODEMK", items?.get(position)?.kodeMk)
            intent.putExtra("NAMADOSEN", items?.get(position)?.namaDosen)
            intent.putExtra("KODEDOSEN1", items?.get(position)?.kodeDosen1)
            intent.putExtra("KODEDOSEN2", items?.get(position)?.kodeDosen2)
            intent.putExtra("SKS1", items?.get(position)?.sks1)
            intent.putExtra("NAMARUANG", items?.get(position)?.namaRuang)
            intent.putExtra("HARI", items?.get(position)?.hari)
            intent.putExtra("WAKTU", items?.get(position)?.waktu)
            intent.putExtra("NAMAMAKUL", items?.get(position)?.namaMk)
            intent.putExtra("NAMAMAKULBAHASAASING", items?.get(position)?.namaMki)
            context.startActivity(intent)
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val namaMataKuliahJadwal = view.listNamaMatakuliahDosenJadwal
        val namaDosenMataKuliahJadwal = view.listNamaDosenJadwal
        val namaHariJadwal = view.listNamaHariJadwal
        val detailJadwal = view.cvKlik
    }
}