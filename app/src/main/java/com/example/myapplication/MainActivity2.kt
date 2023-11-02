package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.myapplication.databinding.ActivityMain2Binding
import com.example.myapplication.databinding.ActivityMainBinding

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
    }

    private fun setupOnclickListener() {
        binding.myper.setOnClickListener {
            val user = binding.txtNameUser.text.toString()
            val intent = Intent(this, MainActivity3::class.java)
            intent.putExtra("KeyUser", user)
            startActivity(intent)
        }
    }

    private fun setupExtras () {
     val userExtra = intent.getStringExtra("KeyUser")

        binding.txtNameUser.text = userExtra
    }

}
