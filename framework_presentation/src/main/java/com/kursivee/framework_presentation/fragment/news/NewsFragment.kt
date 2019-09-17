package com.kursivee.framework_presentation.fragment.news

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kursivee.framework_domain.fragment.BaseFragment
import com.kursivee.framework_domain.handler.KeyboardHandler
import com.kursivee.framework_domain.injector.ext.injector
import com.kursivee.framework_presentation.R
import com.kursivee.framework_presentation.fragment.news.di.NewsDagger
import com.kursivee.framework_presentation.fragment.news.udf.NewsState
import com.kursivee.network_domain.news.model.Article
import kotlinx.android.synthetic.main.news_fragment.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
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
        rv_news.init(newsListAdapter, LinearLayoutManager(context))
        srl_news.setOnRefreshListener {
            vm.getTopHeadlines(et_input.text.toString())
        }
        btn_submit.setOnClickListener {
            (requireActivity() as KeyboardHandler).hideKeyboard()
            vm.getTopHeadlines(et_input.text.toString())
        }
        vm.store.state.observe {
            rv_news.render(it.articles)
            if(it.loading) { startProgress() } else {
                stopProgress()
                srl_news.isRefreshing = false
            }
            if(it.error.isNotEmpty()) { AlertDialog.Builder(context).setMessage(it.error).show() }
        }
        super.onActivityCreated(savedInstanceState)
    }

    private fun RecyclerView.render(articles: List<Article>) {
        newsListAdapter.updateList(articles)
        scrollToPosition(0)
    }

    private fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW).setData(Uri.parse(url))
        startActivity(intent)
    }
}

