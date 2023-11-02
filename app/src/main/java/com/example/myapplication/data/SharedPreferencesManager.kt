package com.example.myapplication.data

import android.content.Context
import  android.content.SharedPreferences
import java.nio.channels.spi.AbstractSelectionKey

class SharedPreferencesManager (private var context: Context) {

    private val name_database = "ME_BASE_DE_DATOS"

    private val SharedPreferences: SharedPreferences by lazy {
        context.getSharedPreferences(name_database, Context.MODE_PRIVATE)
    }

    fun saveUser(user: String) {
        val editor = SharedPreferences.edit()
        editor.putString("KeyUserPref", user)
        editor.apply()
    }

    fun saveBoolean(user: String) {
        val editor = SharedPreferences.edit()
        editor.putString("meBoolean", true)
        editor.apply()
    }


    fun getUser (): String {
        return SharedPreferences.getString("KeyUserPref", "Empty").toString()

    }

    fun getBoolean(): Boolean {
    return  SharedPreferences.getBoolean("meBoolean", false)
    }
}