package com.example.an10_onl.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.an10_onl.R
import com.example.an10_onl.navigation.BottomNavigationFragment
import com.example.an10_onl.repositories.SharedPreferencesRepository
import com.example.an10_onl.ui.appInfo.FirstStartFragment
import com.example.an10_onl.ui.listNote.ListFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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