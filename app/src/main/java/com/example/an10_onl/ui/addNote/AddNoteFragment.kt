package com.example.an10_onl.ui.addNote

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.an10_onl.utils.validation.Invalid
import com.example.an10_onl.R
import com.example.an10_onl.ui.listNote.ListFragment
import com.example.an10_onl.databinding.FragmentAddnoteBinding
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDate

@AndroidEntryPoint
class AddNoteFragment : Fragment() {
    private var titleInputLayout: TextInputLayout? = null
    private var messageInputLayout: TextInputLayout? = null
    private lateinit var binding: FragmentAddnoteBinding
    private val viewModel: AddNoteViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddnoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        titleInputLayout = binding.title
        messageInputLayout = binding.message
        val date = LocalDate.now()
        binding.addNote.setOnClickListener {
            if (validate()) {
                viewModel.addNote(0,
                        binding.titleField.text.toString(),
                        binding.messageField.text.toString(),
                        date.toString()
                    )
                parentFragmentManager.beginTransaction()
                    .replace(R.id.container, ListFragment())
                    .commit()
            }
        }
    }

    private fun validate(): Boolean {
        val isTitleValid = validateTitle()
        val isMessageValid = validateMessage()


        return isTitleValid == null && isMessageValid == null
    }

    private fun validateTitle(): String? {
        titleInputLayout?.editText?.let {
            return when (val result = com.example.an10_onl.utils.validation.validateTitle(it.text.toString())) {
                is Invalid -> {
                    titleInputLayout?.error = this.getString(result.errorText)
                    this.getString(result.errorText)
                }
                else -> {
                    titleInputLayout?.error = null
                    null
                }
            }
        } ?: return null
    }

    private fun validateMessage(): String? {
        messageInputLayout?.editText?.let {
            return when (val result = com.example.an10_onl.utils.validation.validateMessage(it.text.toString())) {
                is Invalid -> {
                    messageInputLayout?.error = this.getString(result.errorText)
                    this.getString(result.errorText)
                }
                else -> {
                    messageInputLayout?.error = null
                    null
                }
            }
        } ?: return null
    }


}