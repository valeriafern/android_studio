package com.example.myapplication.UI

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        binding = ActivityMain2Binding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        initIU()
    }




    private  fun initIU(){
    setupOnclickListener()
        setupExtras()
        setupPreferences()
    }


    private fun setupOnclickListener() {
        binding.myper.setOnClickListener {
          SharedPref.removeSharedPref("userLogged")
        }
    }

    private fun setupExtras () {
     val userExtra = intent.getStringExtra("KeyUser")

        setupPref()
    }

    private  fun setupPreferences(){
        val user= sharedPref.getuser()
        Toast.makeText(this, user, Toast.LENGTH_LONG).show()
    }

}
