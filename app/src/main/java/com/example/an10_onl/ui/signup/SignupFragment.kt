package com.example.an10_onl.ui.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.an10_onl.utils.validation.EmailValidator
import com.example.an10_onl.utils.validation.Invalid
import com.example.an10_onl.R
import com.example.an10_onl.ui.listNote.ListFragment
import com.example.an10_onl.ui.login.LoginFragment
import com.example.an10_onl.databinding.FragmentSignupBinding
import com.example.an10_onl.navigation.BottomNavigationFragment
import com.example.an10_onl.repositories.SharedPreferencesRepository
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignupFragment : Fragment() {
    private var emailInputLayout: TextInputLayout? = null
    private var passwordInputLayout: TextInputLayout? = null
    private var firstNameInputLayout: TextInputLayout? = null
    private var lastNameInputLayout: TextInputLayout? = null
    private lateinit var binding: FragmentSignupBinding
    private val viewModel: SignupViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sharedPreferencesRepository = SharedPreferencesRepository(requireContext())
        emailInputLayout = binding.emailSignup
        passwordInputLayout = binding.passwordSignup
        firstNameInputLayout = binding.firstNameSignup
        lastNameInputLayout = binding.lastNameSignup

        binding.loginFromSignup.setOnClickListener{
//            findNavController().navigate(R.id.action_signupFragment_to_loginFragment)
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, LoginFragment())
                .commit()
        }
        binding.signupButton.setOnClickListener{
            if (validate()) {
                viewModel.addUser(
                    binding.emailField.text.toString(),
                    binding.passwordField.text.toString(),
                    binding.firstNameField.text.toString(),
                    binding.lastNameField.text.toString()
                )
                sharedPreferencesRepository.setUserName(
                    binding.emailField.text.toString()
                )
                sharedPreferencesRepository.setUserPassword(
                    binding.passwordField.text.toString()
                )
                parentFragmentManager.beginTransaction()
                    .setCustomAnimations(R.anim.anim_next_fragment, R.anim.anim_previous_fragment)
                    .add(R.id.container, ListFragment())
                    .commit()
                parentFragmentManager.beginTransaction()
                    .setCustomAnimations(R.anim.anim_next_fragment, R.anim.anim_previous_fragment)
                    .add(R.id.navigation_bar, BottomNavigationFragment())
                    .commit()
            }
        }
    }

    private fun validate(): Boolean {
        val isEmailValid = validateEmail()
        val isPasswordValid = validatePassword()
        val isFirstNameValid = validateFirstName()
        val isLastNameValid = validateLastName()

        return isEmailValid == null && isPasswordValid == null && isFirstNameValid == null && isLastNameValid == null
    }

    private fun validateEmail(): String? {
        emailInputLayout?.editText?.let {
            return when (val result = EmailValidator.validateEmail(it.text.toString())) {
                is Invalid -> {
                    emailInputLayout?.error = this.getString(result.errorText)
                    this.getString(result.errorText)
                }
                else -> {
                    emailInputLayout?.error = null
                    null
                }
            }
        } ?: return null
    }

    private fun validatePassword(): String? {
        passwordInputLayout?.editText?.let {
            return when (val result = com.example.an10_onl.utils.validation.validatePassword(it.text.toString())) {
                is Invalid -> {
                    passwordInputLayout?.error = this.getString(result.errorText)
                    this.getString(result.errorText)
                }
                else -> {
                    passwordInputLayout?.error = null
                    null
                }
            }
        } ?: return null
    }

    private fun validateFirstName(): String? {
        firstNameInputLayout?.editText?.let {
            return when (val result = com.example.an10_onl.utils.validation.validateFirstName(it.text.toString())) {
                is Invalid -> {
                    firstNameInputLayout?.error = this.getString(result.errorText)
                    this.getString(result.errorText)
                }
                else -> {
                    firstNameInputLayout?.error = null
                    null
                }
            }
        } ?: return null
    }

    private fun validateLastName(): String? {
        lastNameInputLayout?.editText?.let {
            return when (val result = com.example.an10_onl.utils.validation.validateLastName(it.text.toString())) {
                is Invalid -> {
                    lastNameInputLayout?.error = this.getString(result.errorText)
                    this.getString(result.errorText)
                }
                else -> {
                    lastNameInputLayout?.error = null
                    null
                }
            }
        } ?: return null
    }


}