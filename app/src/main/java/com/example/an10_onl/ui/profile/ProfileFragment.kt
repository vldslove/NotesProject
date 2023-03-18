package com.example.an10_onl.ui.profile

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.an10_onl.R
import com.example.an10_onl.databinding.FragmentProfileBinding
import com.example.an10_onl.repositories.SharedPreferencesRepository
import com.example.an10_onl.ui.login.LoginFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
@AndroidEntryPoint
class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private var note = " note"
    private val viewModel: ProfileViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n", "ResourceType")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sharedPreferencesRepository = SharedPreferencesRepository(requireContext())
        binding.deleteProfile.setOnClickListener {
            sharedPreferencesRepository.logout()
            viewModel.listUsers.observe(viewLifecycleOwner){
                it.forEach{
                    if(binding.profileName.text.toString() == it.email)
                        viewModel.userDelete(it)
                }
            }
            Toast.makeText(requireContext(), "Account deleted", Toast.LENGTH_LONG).show()
                parentFragmentManager.beginTransaction()
                    .replace(R.id.container, LoginFragment())
                    .addToBackStack("")
                    .commit()

        }
        viewModel.getUsers()
        binding.profileName.text = sharedPreferencesRepository.getUserName()
        lifecycleScope.launch {
            binding.notesCount.setText("${viewModel.getSize()}" + note)
        }

        binding.deleteNotes.setOnClickListener {
            viewModel.deleteNotes()
            binding.notesCount.text = ProfileViewModel.none

        }
        binding.profileLogout.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, LoginFragment())
                .commit()

        }
    }

}