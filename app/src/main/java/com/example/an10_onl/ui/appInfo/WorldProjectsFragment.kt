package com.example.an10_onl.ui.appInfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.navigation.fragment.findNavController
import com.example.an10_onl.R
import com.example.an10_onl.databinding.FragmentWorldprojectsBinding
import com.example.an10_onl.ui.pager.PagerAdapter

class WorldProjectsFragment : Fragment() {
    private lateinit var binding: FragmentWorldprojectsBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWorldprojectsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.skip2.setOnClickListener{
            parentFragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.anim_next_fragment, R.anim.anim_previous_fragment)
                .replace(R.id.container, MakeMoneyActivity())
                .commit()
        }
    }
}