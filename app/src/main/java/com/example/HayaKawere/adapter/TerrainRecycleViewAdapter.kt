package com.example.HayaKawere.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RatingBar
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.HayaKawere.R
import com.example.HayaKawere.entities.TerrainItem
import com.example.HayaKawere.view.activities.DetailActivity


class TerrainRecycleViewAdapter constructor(var mcontext: Context,private val dataSet: ArrayList<TerrainItem>) :
    RecyclerView.Adapter<TerrainRecycleViewAdapter.ViewHolder>() {
     var context:Context?=null
    init {
        this.context = mcontext
    }


    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titre: TextView
        val reserver: Button
        val rating: RatingBar
        val description: TextView
        val localisation: TextView
        val nbjoueurs: TextView
        val heures: TextView
        val testtttttkjhabdkjazhekjazh:RelativeLayout

        init {
            // Define click listener for the ViewHolder's View.
            titre = view.findViewById(R.id.titre)
            reserver = view.findViewById(R.id.bt_reserver)
            rating = view.findViewById(R.id.rb)
            heures = view.findViewById(R.id.heures)
            nbjoueurs = view.findViewById(R.id.nbjoueurs)
            localisation = view.findViewById(R.id.localisation)
            description = view.findViewById(R.id.description)
            testtttttkjhabdkjazhekjazh= view.findViewById<RelativeLayout>(R.id.rl_list_terrain)


        }
    }


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.list_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        var terrainItem = dataSet[position]
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.titre.text = terrainItem.soccerFieldName
        viewHolder.description.text = terrainItem.price.toString()
        viewHolder.testtttttkjhabdkjazhekjazh.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v:View) {
                val intent = Intent(context, DetailActivity::class.java)
                context!!.
                startActivity(intent)
            }
        })




    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size





}

