package com.kursivee.framework_data.fragment.lookup

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.kursivee.framework_data.R
import com.kursivee.framework_data.fragment.lookup.di.LookupDagger
import com.kursivee.framework_domain.injector.ext.injector
import com.kursivee.framework_domain.fragment.BaseFragment
import kotlinx.android.synthetic.main.lookup_fragment.*
import javax.inject.Inject

class LookupFragment : BaseFragment<LookupDagger.LookupComponent>() {

    override val injector: LookupDagger.LookupComponent by lazy {
        requireActivity().injector<LookupDagger.AppGraph>()
            .p3builder()
            .build()
    }

    companion object {
        fun newInstance() = LookupFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: LookupViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.lookup_fragment, container, false)
    }

    override fun onAttach(context: Context) {
        injector.inject(this)
        super.onAttach(context)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(LookupViewModel::class.java)
        viewModel.loading.observe(viewLifecycleOwner, Observer {
            if(it) {
                showSpinner()
            } else {
                hideSpinner()
            }
        })
        viewModel.s.observe(viewLifecycleOwner, Observer {
            tv_hello.text = it
        })
        btn_submit.setOnClickListener {
            viewModel.getIPInfo(et_input.text.toString())
        }
    }

}
