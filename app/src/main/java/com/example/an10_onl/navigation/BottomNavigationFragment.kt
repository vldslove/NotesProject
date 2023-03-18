package com.example.an10_onl.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.an10_onl.R
import com.example.an10_onl.ui.addNote.AddNoteFragment
import com.example.an10_onl.ui.listNote.ListFragment
import com.example.an10_onl.ui.profile.ProfileFragment
import com.example.an10_onl.ui.search.SearchFragment
import com.example.an10_onl.databinding.FragmentBottomnavigationBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class BottomNavigationFragment : Fragment() {
    private lateinit var binding: FragmentBottomnavigationBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBottomnavigationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.list -> {
                parentFragmentManager.beginTransaction()
                    .setCustomAnimations(R.anim.anim_next_fragment, R.anim.anim_previous_fragment)
                    .replace(R.id.container, ListFragment())
                    .addToBackStack("")
                    .commit()
                    true
                }
                R.id.search -> {
                    parentFragmentManager.beginTransaction()
                        .setCustomAnimations(R.anim.anim_next_fragment, R.anim.anim_previous_fragment)
                        .replace(R.id.container, SearchFragment())
                        .addToBackStack("")
                        .commit()
                    true
                }
                R.id.addNote -> {
                    parentFragmentManager.beginTransaction()
                        .setCustomAnimations(R.anim.anim_next_fragment, R.anim.anim_previous_fragment)
                        .replace(R.id.container, AddNoteFragment())
                        .addToBackStack("")
                        .commit()
                    true
                }
                R.id.profile -> {
                    parentFragmentManager.beginTransaction()
                        .setCustomAnimations(R.anim.anim_next_fragment, R.anim.anim_previous_fragment)
                        .replace(R.id.container, ProfileFragment())
                        .addToBackStack("")
                        .commit()
                    true
                }
                else -> {
                    false
                }

            }
        }
    }
}