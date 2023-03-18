package com.example.an10_onl.ui.appInfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.an10_onl.R
import com.example.an10_onl.databinding.FragmentChatanddevelopBinding

class ChatAndDevelopFragment : Fragment() {
    private lateinit var binding: FragmentChatanddevelopBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChatanddevelopBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.skip4.setOnClickListener{
//            findNavController().navigate(R.id.action_chatAndDevelopFragment_to_levelUpFragment)
            parentFragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.anim_next_fragment, R.anim.anim_previous_fragment)
                .replace(R.id.container, LevelUpFragment())
                .commit()
        }
    }
}