
package com.example.HayaKawere

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    private var param1: String? = ""
    private var param2: String? = null
    var tv_homeFragment: TextView? = null
    var str = ""
    var pager: ViewPager? = null
    var tabLayout: TabLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_home, container, false)
        initView(view)
        initData()
        initFields()
        Toast.makeText(requireContext(), " from hell ", Toast.LENGTH_LONG).show()
        return view
    }

    private fun initFields() {
        /* if (!param1.equals("")){
             tv_homeFragment!!.text= param1
         }*/

    }

    private fun initData() {
        /* if (arguments!=null){
             str= arguments?.getString("omar").toString()

         }*/
    }

    private fun initView(view: View?) {
        pager = view!!.findViewById(R.id.pager)
        tabLayout = view!!.findViewById(R.id.tab_layout)
        var viewPagerAdapter = fragmentManager?.let {
            TabsViewPagerAdapter(
                requireContext(),
                it
            )
        }
        pager!!.adapter=viewPagerAdapter
        tabLayout!!.setupWithViewPager(pager)
   }

    companion object {

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment homeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(parm1: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, parm1)
                    putString(ARG_PARAM2, "param2")
                }
            }
    }
}