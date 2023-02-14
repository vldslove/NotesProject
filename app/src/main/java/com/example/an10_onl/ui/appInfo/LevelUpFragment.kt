package com.example.an10_onl.ui.appInfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.an10_onl.R
import com.example.an10_onl.databinding.FragmentLevelupBinding

class LevelUpFragment : Fragment() {
    private lateinit var binding: FragmentLevelupBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLevelupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.skip5.setOnClickListener{
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, ProgressFragment())
                .commit()
        }
    }
}