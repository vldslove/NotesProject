package com.example.an10_onl.ui.pager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.an10_onl.ui.appInfo.*
import com.example.an10_onl.ui.signup.SignupFragment
import com.example.an10_onl.ui.signup.SignupFragment_GeneratedInjector

class PagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    override fun getCount(): Int = 5

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                WorldProjectsFragment()
            }
            1 -> {
                MakeMoneyActivity()
            }
            2 -> {
                ChatAndDevelopFragment()
            }
            3 -> {
                LevelUpFragment()
            }
            4 -> {
                ProgressFragment()
            }
            else -> {
                SignupFragment()
            }
        }

    }
}