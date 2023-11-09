package com.example.myapplication.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.myapplication.R
import com.example.myapplication.data.SharedPreferencesManager

class SplashScreenActivity : AppCompatActivity() {

    private val TIMER_SPLASH = 3000L
    private lateinit var sharedPref: SharedPreferencesManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPref = SharedPreferencesManager(this)

        setContentView(R.layout.activity_splash_screen)
        initUI()
    }

    private fun initUI (){
        setupJumpNextActivity()
    }

    private fun  setupJumpNextActivity() {
        val userLogged = sharedPref.getPref("userLogged", false) as Boolean
        Looper.myLooper()?.let {
            Handler(it).postDelayed(
                {
                    if (userLogged){
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    }else{
                    val intent = Intent(this, MainActivity2::class.java)
                    startActivity(intent)}
                },TIMER_SPLASH
            )
        }
    }

}