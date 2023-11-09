package com.example.myapplication.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {

    private lateinit var binding:ActivityMain3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        binding = ActivityMain3Binding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        initIU()
    }

    private  fun initIU(){
        setupOnclickListener()
        setupExtras()
    }

    private fun setupOnclickListener() {
        binding.finalizar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupExtras () {
        val userExtra = intent.getStringExtra("KeyUser")

        binding.txtNameUser2.text = userExtra
    }

}
