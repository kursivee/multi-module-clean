package com.kursivee.framework_presentation.fragment.news

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.kursivee.framework_domain.fragment.BaseFragment
import com.kursivee.framework_domain.handler.KeyboardHandler
import com.kursivee.framework_domain.injector.ext.injector
import com.kursivee.framework_presentation.R
import com.kursivee.framework_presentation.fragment.news.di.NewsDagger
import kotlinx.android.synthetic.main.news_fragment.*
import javax.inject.Inject


class NewsFragment : BaseFragment<NewsDagger.NewsComponent, NewsViewModel>() {

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

    private val newsListAdapter = NewsAdapter(R.layout.article_layout, onClick = ::openUrl)
    
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
        vm = ViewModelProviders.of(this, viewModelFactory).get(NewsViewModel::class.java)
        super.onActivityCreated(savedInstanceState)
        rv_news.init(newsListAdapter)
        vm.articles.observe {
            newsListAdapter.updateList(it)
            rv_news.scrollToPosition(0)
        }
        btn_submit.setOnClickListener {
            (requireActivity() as KeyboardHandler).hideKeyboard()
            vm.getTopHeadlines(et_input.text.toString())
        }
    }

    private fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW).setData(Uri.parse(url))
        startActivity(intent)
    }
}

