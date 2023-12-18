package com.pjff.dashboard.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pjff.dashboard.databinding.ActivityMainBinding
import androidx.fragment.app.Fragment
import com.pjff.dashboard.Home
import com.pjff.dashboard.Profile
import com.pjff.dashboard.R
import com.pjff.dashboard.Settings


class DashboardActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Home())

        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){

                R.id.home -> replaceFragment(Home())
                R.id.profile -> replaceFragment(Profile())
                R.id.settings -> replaceFragment(Settings())

                else ->{



                }

            }

            true

        }


    }

    private fun replaceFragment(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()


    }
}