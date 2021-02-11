package com.example.planespotter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_splash_screen.*

//FOR MOBILE DEVELOPMENT BY FERDI VAN DEN BROM | 2079865

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        logo.alpha = 0f
        logo.animate().setDuration(2500).alpha(1f).withEndAction {
            val e = Intent(this, MainActivity::class.java)
            startActivity(e)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
        }
    }
}