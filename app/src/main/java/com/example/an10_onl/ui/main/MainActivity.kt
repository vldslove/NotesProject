package com.example.an10_onl.ui.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentPagerAdapter
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.an10_onl.R
import com.example.an10_onl.databinding.ActivityMainBinding
import com.example.an10_onl.navigation.BottomNavigationFragment
import com.example.an10_onl.repositories.SharedPreferencesRepository
import com.example.an10_onl.ui.appInfo.FirstStartFragment
import com.example.an10_onl.ui.listNote.ListFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferencesRepository = SharedPreferencesRepository(this)
        if (sharedPreferencesRepository.getUserName() != null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.container, ListFragment())
                .addToBackStack("")
                .commit()
            supportFragmentManager.beginTransaction()
                .add(R.id.navigation_bar, BottomNavigationFragment())
                .addToBackStack("")
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, FirstStartFragment())
                .commit()

        }

    }

}