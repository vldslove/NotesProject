package com.example.an10_onl.ui.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.example.an10_onl.databinding.ShowNoteBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ItemBottomDialog : BottomSheetDialogFragment() {
    private val TITLE_EXTRA = "title"
    private val MESSAGE_EXTRA = "message"
    private lateinit var binding: ShowNoteBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ShowNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.titleShow.text = arguments?.getString(TITLE_EXTRA)
        binding.messageShow.text = arguments?.getString(MESSAGE_EXTRA)

    }

        fun getNoteFragmentInstance(title: String, message: String): ItemBottomDialog {
            return ItemBottomDialog().apply {
                arguments = bundleOf(
                    TITLE_EXTRA to title,
                    MESSAGE_EXTRA to message
                )

        }
    }
}