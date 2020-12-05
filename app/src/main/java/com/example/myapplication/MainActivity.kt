package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import com.example.myapplication.fragments.HomeFragment
import com.example.myapplication.fragments.SettingsFragment
import com.example.myapplication.model.User
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {



    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_nav)
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        openFragment(HomeFragment.newInstance())

    }

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.home -> {
                val homeFragment = HomeFragment.newInstance()
                openFragment(homeFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.settings -> {
                val settingsFragment = SettingsFragment.newInstance()
                openFragment(settingsFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).addToBackStack(null).commit()
    }
}