package com.huda.ta_mobile_programming.tampilan.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.huda.ta_mobile_programming.R
import com.huda.ta_mobile_programming.helper.ConfigData
import com.huda.ta_mobile_programming.tampilan.DetailCariActivity
import kotlinx.android.synthetic.main.fragment_data_cari.*


class DataCariFragment : Fragment() {
    lateinit var btnCari: Button
    lateinit var edtNpm: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_data_cari, container, false)
        btnCari = view.findViewById(R.id.btnCari)
        edtNpm = view.findViewById(R.id.etNpm)
        btnCari.setOnClickListener {
            if (edtNpm.text.isEmpty()) {
                Toast.makeText(activity, "NPM Masih Kosong", Toast.LENGTH_SHORT).show()
            }
            else {
                val intent: Intent = Intent(activity, DetailCariActivity::class.java)
//                intent.putExtra(etNpm.text.toString().trim())
//                intent.putExtra("f7bd80b1324690c3f15dc6a5cab3e1")
                intent.putExtra(ConfigData.BUNDLE_NPM, etNpm.text.toString().trim())
                intent.putExtra(ConfigData.BUNDLE_KEY, "f7bd80b1324690c3f15dc6a5cab3e1")
                startActivity(intent)
            }
        }
        return view
    }

}
