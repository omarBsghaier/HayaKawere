package com.example.HayaKawere.adapter

import android.content.Context
import android.graphics.Color
import androidx.core.graphics.toColor
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.HayaKawere.R
import com.example.HayaKawere.view.fragment.acceuil.home.EvenementFragment
import com.example.HayaKawere.view.fragment.acceuil.home.TerrainFragment

class TabsViewPagerAdapter(context: Context, manager: FragmentManager) : FragmentPagerAdapter( manager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
 {
     private var TAB_TITLES = arrayListOf(R.string.tab_text_1, R.string.tab_text_2)
     private lateinit var mContext: Context

     init {
         mContext=context
     }

     /**
      * Return the number of views available.
      */
     override fun getCount(): Int {
         return 2
     }

     /**
      * Return the Fragment associated with a specified position.
      */
     override fun getItem(position: Int): Fragment {
         return when(position) {

             0-> TerrainFragment.newInstance("", "")

             else-> EvenementFragment.newInstance("", "")
            // else ->HomeFragment.newInstance("")
         }
 }

     override fun getPageTitle(position: Int): CharSequence? {
         return mContext.resources.getString(TAB_TITLES[position])
     }
}
