package com.huda.ta_mobile_programming.tampilan

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.huda.ta_mobile_programming.R
import com.huda.ta_mobile_programming.helper.ConfigData
import kotlinx.android.synthetic.main.data_cari.*

class DataCari : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.data_cari)
        supportActionBar?.hide()
        btnCari.setOnClickListener {
            if (etNpm.text.isEmpty()){
                Toast.makeText(this, "NPM masih Kosong Gan", Toast.LENGTH_LONG).show()
            } else{
                val intent : Intent = Intent(this, MainActivity::class.java)
//                intent.putExtra(etNpm.text.toString().trim())
//                intent.putExtra("f7bd80b1324690c3f15dc6a5cab3e1")
                intent.putExtra(ConfigData.BUNDLE_NPM,etNpm.text.toString().trim())
                intent.putExtra(ConfigData.BUNDLE_KEY,"f7bd80b1324690c3f15dc6a5cab3e1")
                startActivity(intent)
            }
        }
    }
}
