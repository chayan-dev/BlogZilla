package com.example.blogzilla.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.blogzilla.databinding.FragmentLoginSignupBinding
import com.example.blogzilla.ui.AuthViewModel

class LoginFragment :Fragment(){

    private var _binding: FragmentLoginSignupBinding ?=null
    val authViewModel: AuthViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentLoginSignupBinding.inflate(inflater,container,false)
        _binding?.usernameEditText?.isVisible=false

//        authViewModel=activityViewModels<AuthViewModel>()

        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding?.apply {
            submitBtn.setOnClickListener{
                authViewModel.login(
                    emailEditText.text.toString(),
                    passwordEditText.text.toString()
                )
            }
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}