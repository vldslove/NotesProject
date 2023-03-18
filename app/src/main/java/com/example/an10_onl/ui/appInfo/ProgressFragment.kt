package com.example.an10_onl.ui.appInfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.an10_onl.R
import com.example.an10_onl.ui.signup.SignupFragment
import com.example.an10_onl.databinding.FragmentProgressBinding

class ProgressFragment : Fragment() {
    private lateinit var binding: FragmentProgressBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProgressBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       binding.skip6.setOnClickListener{
            parentFragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.anim_next_fragment, R.anim.anim_previous_fragment)
                .replace(R.id.container, SignupFragment())
                .commit()
    }
    }
}
