package com.example.an10_onl.ui.pager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.an10_onl.databinding.FragmentSwipeBinding

class PageFragment : Fragment() {

    private lateinit var binding: FragmentSwipeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSwipeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewPager = binding.pager
        val pagerAdapter = PagerAdapter(parentFragmentManager)
        viewPager.adapter = pagerAdapter
    }
}