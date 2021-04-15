package com.example.HayaKawere.view.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import com.example.HayaKawere.R
import me.jlurena.revolvingweekview.WeekView
import me.jlurena.revolvingweekview.WeekView.WeekViewLoader


class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        var retour =findViewById<ImageView>(R.id.iv_retour_activity_detail)
        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.image_terrrain1))
        imageList.add(SlideModel(R.drawable.image_terrrain1))
        imageList.add(SlideModel(R.drawable.image_terrrain1))
        val imageSlider = findViewById<ImageSlider>(R.id.image_slider)
        imageSlider.setImageList(imageList)
// Get a reference for the week view in the layout.
        // Get a reference for the week view in the layout.
      var  mWeekView = findViewById<View>(R.id.revolving_weekview) as WeekView

        // Set an WeekViewLoader to draw the events on load.
        mWeekView.setWeekViewLoader(WeekViewLoader {
            // Add some event
            ArrayList()
        })

          retour.setOnClickListener(object : View.OnClickListener {
              override fun onClick(v: View) {
                  val intent = Intent(this@DetailActivity, AcceuilActivity::class.java)

                  startActivity(intent)
              }
          })

}



}