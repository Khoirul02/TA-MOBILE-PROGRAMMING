package com.huda.ta_mobile_programming.tampilan

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.huda.ta_mobile_programming.R

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        val background = object : Thread(){
            override fun run() {
                try {
                    Thread.sleep(4000)

                    val intent = Intent(baseContext, MainActivity::class.java)
                    startActivity(intent )
                } catch (e:Exception){
                    e.printStackTrace()
                }
            }
        }
        background.start()
    }
}