package com.example.HayaKawere

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class OnBordingViewAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(
    fragmentManager,
    FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getCount(): Int {
        return 3
    }


    /**
     * Return the Fragment associated with a specified position.
     */
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> OnBordingFragment1.newInstance("", "")
            1 -> OnBordingFragment2.newInstance("", "")
            2 -> OnBordingFragment3.newInstance("", "")

            else -> OnBordingFragment1.newInstance("", "")

        }


    }


}