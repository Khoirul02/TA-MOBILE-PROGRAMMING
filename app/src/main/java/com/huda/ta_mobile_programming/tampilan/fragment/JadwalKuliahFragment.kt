package com.huda.ta_mobile_programming.tampilan.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView

import com.huda.ta_mobile_programming.R
import com.huda.ta_mobile_programming.adapter.JadwalKuliahAdapter
import com.huda.ta_mobile_programming.data.model.jadwal.JadwalItem
import com.huda.ta_mobile_programming.presenter.JadwalKuliahPresenter

class JadwalKuliahFragment : Fragment() {

    private lateinit var JadwalKuliahAdapter: JadwalKuliahAdapter
    private lateinit var JadwalKuliahPresenter: JadwalKuliahPresenter
    private var items: ArrayList<JadwalItem> = arrayListOf()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view : View = inflater.inflate(R.layout.fragment_jadwal_kuliah, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.rv)
        val progressBar: ProgressBar = view.findViewById(R.id.progress)
        val tvProgress: TextView = view.findViewById(R.id.tvProgressBar)
        JadwalKuliahAdapter = JadwalKuliahAdapter(activity, items)
        JadwalKuliahPresenter= JadwalKuliahPresenter(items, activity, recyclerView, JadwalKuliahAdapter, progressBar, tvProgress)
        JadwalKuliahPresenter.getJadwalKuliah()

        return view
    }


}
