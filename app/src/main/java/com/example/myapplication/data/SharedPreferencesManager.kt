package com.example.myapplication.data

import android.content.Context
import  android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import java.lang.IllegalArgumentException
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

    fun saveBoolean() {
        val editor = SharedPreferences.edit()
        editor.putBoolean("meBoolean", true)
        editor.apply()
    }

    fun getUser (): String {
        return SharedPreferences.getString("KeyUserPref", "Empty").toString()

    }

    fun getUsersIsLogged(): Boolean {
    return  SharedPreferences.getBoolean("meBoolean", false)
    }

    fun removeSharedPref(Key: String){
        val editor = SharedPreferences.edit()
        editor.remove(Key)
        editor.apply()
    }

    //solucion a posible problema de escalabilidad

    fun savePref(Key: String, Value:Any){
        val editor = SharedPreferences.edit()
        when(Value){
            is String -> editor.putString(Key, Value)
            is Int -> editor.putInt(Key, Value)
            is Boolean -> editor.putBoolean(Key, Value)
            is Float -> editor.putFloat(Key, Value)
            is Long -> editor.putLong(Key, Value)
            else -> throw IllegalArgumentException("EL VALOR NO ES VALIDO")
        }
        editor.apply()

    }

    fun getPref(Key: String, defaultValue:Any):Any {
        val SharedPreferences = context.getSharedPreferences(name_database, Context.MODE_PRIVATE)
        return when(defaultValue){
          is String -> SharedPreferences.getString(Key, defaultValue)
          is Int -> SharedPreferences.getInt(Key, defaultValue)
            is Boolean -> SharedPreferences.getBoolean(Key, defaultValue)
            is Float ->SharedPreferences.getFloat(Key, defaultValue)
            is Long -> SharedPreferences.getLong(Key, defaultValue)
            else -> throw IllegalArgumentException("NO SE ENCONTRO EN LA BASE DE DATOS")

        }!!
    }

}