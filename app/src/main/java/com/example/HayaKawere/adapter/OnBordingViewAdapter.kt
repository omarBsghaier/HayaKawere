package com.example.HayaKawere.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.HayaKawere.view.fragment.onBoarding.OnBordingFragment1
import com.example.HayaKawere.view.fragment.onBoarding.OnBordingFragment2
import com.example.HayaKawere.view.fragment.onBoarding.OnBordingFragment3

class OnBordingViewAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getCount(): Int {
        return 3
    }


    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> OnBordingFragment1.newInstance("", "")
            1 -> OnBordingFragment2.newInstance("", "")
            2 -> OnBordingFragment3.newInstance("", "")

            else -> OnBordingFragment1.newInstance("", "")

        }


    }


}