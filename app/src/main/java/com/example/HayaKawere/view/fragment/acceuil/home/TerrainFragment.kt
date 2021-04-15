package com.example.HayaKawere.view.fragment.acceuil.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.HayaKawere.R
import com.example.HayaKawere.adapter.TerrainRecycleViewAdapter
import com.example.HayaKawere.entities.TerrainItem


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TerrainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TerrainFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var mcontext : Context?=null

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
        var view= inflater.inflate(R.layout.fragment_terrain, container, false)

        initView(view)

        return view
    }

    private fun initView(view: View?) {
        var rvListTerrain= view?.findViewById<RecyclerView>(R.id.rv_list_terrain_fragment_terrain)
        var terrainItemList= ArrayList<TerrainItem>()
        terrainItemList.add(TerrainItem("soccerFIeld 1", 10))
        terrainItemList.add(TerrainItem("soccerFIeld 2", 10))
        terrainItemList.add(TerrainItem("soccerFIeld 2", 10))
        terrainItemList.add(TerrainItem("soccerFIeld 2", 10))
        terrainItemList.add(TerrainItem("soccerFIeld 2", 10))
        terrainItemList.add(TerrainItem("soccerFIeld 2", 10))
        terrainItemList.add(TerrainItem("soccerFIeld 2", 10))
        terrainItemList.add(TerrainItem("soccerFIeld 2", 10))
        terrainItemList.add(TerrainItem("soccerFIeld 2", 10))
        terrainItemList.add(TerrainItem("soccerFIeld 2", 10))
        terrainItemList.add(TerrainItem("soccerFIeld 2", 10))
        terrainItemList.add(TerrainItem("soccerFIeld 2", 10))
        terrainItemList.add(TerrainItem("soccerFIeld 2", 10))
        var terrainRecycleViewAdapter= TerrainRecycleViewAdapter(requireContext(), terrainItemList)
        var layoutManager= LinearLayoutManager(requireContext())
        rvListTerrain!!.layoutManager = layoutManager
        rvListTerrain!!.adapter= terrainRecycleViewAdapter
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TerrainFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TerrainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}