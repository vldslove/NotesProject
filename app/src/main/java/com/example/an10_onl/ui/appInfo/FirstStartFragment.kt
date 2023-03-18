package com.example.an10_onl.ui.appInfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.an10_onl.R
import com.example.an10_onl.ui.login.LoginFragment
import com.example.an10_onl.databinding.FragmentFirststartBinding
import com.example.an10_onl.ui.pager.PageFragment

class FirstStartFragment : Fragment() {
    private lateinit var binding: FragmentFirststartBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirststartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.discoverThePlatform.setOnClickListener{
//            findNavController().navigate(R.id.action_firstStartFragment_to_worldProjectsFragment)
            parentFragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.anim_next_fragment, R.anim.anim_previous_fragment)
                .replace(R.id.container, PageFragment())
                .commit()
        }
        binding.login.setOnClickListener{
//            findNavController().navigate(R.id.action_firstStartFragment_to_loginFragment)
            parentFragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.anim_next_fragment, R.anim.anim_previous_fragment)
                .replace(R.id.container, LoginFragment())
                .commit()
        }
    }

}