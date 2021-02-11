package com.example.planespotter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

//FOR MOBILE DEVELOPMENT BY FERDI VAN DEN BROM | 2079865

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //BUTTONS & CLICK LISTENERS START

        goToPlanes.setOnClickListener {
            startActivity(Intent(this, PlanesActivity::class.java))
        }

        goToLatestSpots.setOnClickListener {
            startActivity(Intent(this, LatestSpotsActivity::class.java))
        }

        //BUTTONS & CLICK LISTENERS END

        //MISCELLANEOUS START

        lifecycleScope.launch { // runs on Main by default
            val specialMessage = withContext(Dispatchers.IO) {
                "Ferdi van den Brom | 2079865 | Mobile Development"
            }
            Ferdi.text = specialMessage
        }

        //MISCELLANEOUS END

    }
}