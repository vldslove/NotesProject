package com.example.an10_onl.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.an10_onl.R
import com.example.an10_onl.ui.signup.SignupFragment
import com.example.an10_onl.ui.listNote.ListFragment
import com.example.an10_onl.databinding.FragmentLoginBinding
import com.example.an10_onl.navigation.BottomNavigationFragment
import com.example.an10_onl.repositories.SharedPreferencesRepository
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var passwordInputLayout: TextInputLayout? = null
    private var emailInputLayout: TextInputLayout? = null
    private lateinit var binding: FragmentLoginBinding
    private val viewModel: LoginViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sharedPreferencesRepository = SharedPreferencesRepository(requireContext())
        passwordInputLayout = view.findViewById(R.id.passwordField)
        emailInputLayout = view.findViewById(R.id.emailField)
        binding.toSignup.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, SignupFragment())
                .commit()
        }


        binding.loginButton.setOnClickListener {
            lifecycleScope.launch {
                if (!binding.emailFieldText.text.isNullOrEmpty() && !binding.passwordFieldText.text.isNullOrEmpty()) {
                    if (viewModel.getUserEmail(binding.emailFieldText.text.toString()).isEmpty()) {
                        Toast.makeText(requireContext(), "Account does not exist", Toast.LENGTH_LONG).show()
                    } else
                        if (viewModel.getUserPassword(binding.passwordFieldText.text.toString()).isEmpty()) {
                            Toast.makeText(requireContext(), "Incorrect password", Toast.LENGTH_LONG).show()
                        } else {
                            sharedPreferencesRepository.setUserName(binding.emailFieldText.text.toString())
                            parentFragmentManager.beginTransaction()
                                .add(R.id.container, ListFragment())
                                .addToBackStack("")
                                .commit()
                            parentFragmentManager.beginTransaction()
                                .add(R.id.navigation_bar, BottomNavigationFragment())
                                .addToBackStack("")
                                .commit()
                        }
                }
            }
        }
    }
}
