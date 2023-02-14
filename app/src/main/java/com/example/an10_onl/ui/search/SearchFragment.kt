package com.example.an10_onl.ui.search

import android.os.Bundle
import android.view.*
import android.widget.PopupMenu
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.an10_onl.R
import com.example.an10_onl.databinding.FragmentSearchBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment(), PopupMenu.OnMenuItemClickListener {
    private lateinit var binding: FragmentSearchBinding
    private var searchAdapter = SearchAdapter()
    private val viewModel: SearchViewModel by viewModels()
    var listNote: RecyclerView? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listNote = binding.recyclerViewSearch
        listNote?.run {
            adapter = searchAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        viewModel.searchResult.observe(viewLifecycleOwner) {
            (listNote?.adapter as SearchAdapter).setList(it)
        }
        viewModel.getList()

        binding.edittexts.doAfterTextChanged {
            viewModel.searchNote(it.toString())
        }

        binding.filters.setOnClickListener {
            val popup = PopupMenu(requireContext(), it)
            popup.setOnMenuItemClickListener(this)
            val inflater: MenuInflater = popup.menuInflater
            inflater.inflate(R.menu.popup_menu, popup.menu)
            popup.show()
        }

    }

    override fun onMenuItemClick(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.test1 -> {
                Toast.makeText(requireContext(), "Done", Toast.LENGTH_LONG).show()
                true
            }
            R.id.test2 -> {
                Toast.makeText(requireContext(), "Done", Toast.LENGTH_LONG).show()
                true
            }
            else -> false
        }

    }
}