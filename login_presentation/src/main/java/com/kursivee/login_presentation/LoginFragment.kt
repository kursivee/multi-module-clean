package com.kursivee.login_presentation

import android.net.Uri
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.kursivee.framework_domain.fragment.BaseFragment
import com.kursivee.framework_domain.injector.ext.injector
import com.kursivee.login_presentation.di.LoginDagger
import kotlinx.android.synthetic.main.login_fragment.*


class LoginFragment : BaseFragment<LoginDagger.LoginComponent, LoginViewModel>() {

    override val injector: LoginDagger.LoginComponent by lazy {
        requireActivity()
            .injector<LoginDagger.AppGraph>()
            .p3builder()
            .build()
    }

    companion object {
        fun newInstance() = LoginFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        vm = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
        tv_hello.setOnClickListener {
            val uri = Uri.parse("app://newsFragment")
            findNavController().navigate(uri)
        }
    }
}
