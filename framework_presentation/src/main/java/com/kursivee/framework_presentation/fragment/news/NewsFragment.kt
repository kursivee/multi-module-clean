package com.kursivee.framework_presentation.fragment.news

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.kursivee.framework_presentation.R
import com.kursivee.framework_presentation.fragment.news.di.NewsDagger
import com.kursivee.framework_domain.injector.ext.injector
import com.kursivee.framework_domain.fragment.BaseFragment
import kotlinx.android.synthetic.main.news_fragment.*
import javax.inject.Inject

class NewsFragment : BaseFragment<NewsDagger.NewsComponent>() {

    override val injector: NewsDagger.NewsComponent by lazy {
        requireActivity().injector<NewsDagger.AppGraph>()
            .p3builder()
            .build()
    }

    companion object {
        fun newInstance() = NewsFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.news_fragment, container, false)
    }

    override fun onAttach(context: Context) {
        injector.inject(this)
        super.onAttach(context)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(NewsViewModel::class.java)
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
