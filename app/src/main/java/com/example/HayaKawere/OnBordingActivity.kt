package com.example.HayaKawere

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cuberto.liquid_swipe.LiquidPager

class OnBordingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onbording)
        var pager = findViewById<LiquidPager>(R.id.vp_onbording_onbordinga_ctivity)
        pager.adapter = OnBordingViewAdapter(supportFragmentManager)


    }
}