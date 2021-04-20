package com.example.HayaKawere.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.HayaKawere.R
import com.example.HayaKawere.entities.EvenementItem
import com.example.HayaKawere.entities.TerrainItem
import java.util.zip.Inflater

class EvenementRecycleViewAdapter constructor(var mcontext: Context, private val dataSet: ArrayList<EvenementItem>) :
    RecyclerView.Adapter<EvenementRecycleViewAdapter.ViewHolderEvenment>() {
    var context: Context?=null
    init {
        this.context = mcontext
    }

      class ViewHolderEvenment(view : View) : RecyclerView.ViewHolder(view) {
          val titre : TextView
          val date : TextView
          init{
              titre = view.findViewById(R.id.tv_titre_evenemnet_list_item_evenement)
              date = view.findViewById(R.id.tv_date_evenement_list_item_evenement)
          }



      }


      override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderEvenment {
          var view = LayoutInflater.from(parent.context)
              .inflate(R.layout.list_item_evenment, parent, false)

          return ViewHolderEvenment(view)
      }



      override fun onBindViewHolder(holder: ViewHolderEvenment, position: Int) {
          var  evenementItem = dataSet[position]

          holder.titre.text = evenementItem.titre
          holder.date.text = evenementItem.date.toString()
      }


      override fun getItemCount() = dataSet.size


  }

