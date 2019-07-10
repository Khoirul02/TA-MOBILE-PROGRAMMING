package com.huda.ta_mobile_programming.presenter

import android.support.v4.app.FragmentActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import com.huda.ta_mobile_programming.adapter.JadwalKuliahAdapter
import com.huda.ta_mobile_programming.data.lib.ApiService
import com.huda.ta_mobile_programming.data.lib.RetroConfig
import com.huda.ta_mobile_programming.data.model.jadwal.JadwalItem
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
@Suppress("UNCHECKED_CAST")
class JadwalKuliahPresenter(
    private var items: ArrayList<JadwalItem> = arrayListOf(),
    private val context: FragmentActivity?,
    private var rv: RecyclerView,
    private var mAdapter: JadwalKuliahAdapter,
    private var progressBar : ProgressBar,
    private var tvprogres : TextView
) {

    fun getJadwalKuliah(){
        progressBar.visibility = View.VISIBLE
        tvprogres.visibility = View.VISIBLE
        val service: ApiService = RetroConfig.provideApi()
        service.getDetilJadwal("f7bd80b1324690c3f15dc6a5cab3e1","16670023")
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                items.clear()
                items = it.data as ArrayList<JadwalItem>
                rv.layoutManager = LinearLayoutManager(context)
                mAdapter = JadwalKuliahAdapter(context, items)
                rv.adapter = mAdapter
                progressBar.visibility = View.INVISIBLE
                tvprogres.visibility = View.INVISIBLE
            }, {
                progressBar.visibility = View.INVISIBLE
                tvprogres.visibility = View.INVISIBLE
            })
    }
}