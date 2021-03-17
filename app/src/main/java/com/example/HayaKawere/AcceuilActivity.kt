package com.example.HayaKawere

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView


class AcceuilActivity : AppCompatActivity() {
//    lateinit var navigationItemSelectedListener: BottomNavigationView
    var navigationItemSelectedListener: BottomNavigationView.OnNavigationItemSelectedListener =
        object : BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(@NonNull item: MenuItem): Boolean {
                when (item.getItemId()) {
                    R.id.action_one -> {
                        openFragment(HomeFragment.newInstance("1"))
                        return true
                    }
                    R.id.action_two -> {
                        Toast.makeText(this@AcceuilActivity, " death ", Toast.LENGTH_LONG)
                            .show()
                        var t = 0
                        println("firas" + t)
                        openFragment(calander.newInstance("2", ""))
                        return true
                    }
                    R.id.action_three -> {
                        openFragment(Favoris.newInstance("3", ""))
                        return true
                    }
                }
                return false
            }
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acceuil)
        var navigationbutton =
            findViewById<BottomNavigationView>(R.id.bottom_navigation)
        openFragment(
            HomeFragment.newInstance(
                "1"
            )
        );
        navigationbutton.setOnNavigationItemSelectedListener(navigationItemSelectedListener)



        /*  supportFragmentManager.beginTransaction().replace(R.id.fragment,HomeFragment()).commit()
          (findViewById<Button>(R.id.b1) as Button).setOnClickListener(object :View.OnClickListener{
              override fun onClick(v: View?) {
                  supportFragmentManager.beginTransaction().replace(R.id.fragment,HomeFragment()).commit()

              }
          })
          (findViewById<Button>(R.id.b2).setOnClickListener{
           var homeFragment=  HomeFragment()
              var bundle:Bundle= Bundle()
              bundle.putString("omar","firas")
              homeFragment.arguments= bundle
              supportFragmentManager.beginTransaction().replace(R.id.fragment,HomeFragment.newInstance("wassim ")).commit()

          })*/
    }

    fun openFragment(fragment: Fragment) {
        val transaction = getSupportFragmentManager().beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
    /**
     * Called when an item in the bottom navigation menu is selected.
     *
     * @param item The selected item
     * @return true to display the item as the selected item and false if the item should not be
     * selected. Consider setting non-selectable items as disabled preemptively to make them
     * appear non-interactive.
     */

}