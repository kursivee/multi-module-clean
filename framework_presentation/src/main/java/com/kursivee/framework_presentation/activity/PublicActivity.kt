package com.kursivee.framework_presentation.activity

import android.os.Bundle
import com.kursivee.framework_presentation.R
import com.kursivee.framework_presentation.fragment.lookup.LookupFragment
import com.kursivee.framework_domain.activity.BaseActivity
import com.kursivee.framework_domain.injector.ext.injector

class PublicActivity : BaseActivity<ActivityDagger.ActivityComponent>(R.id.pb_loading) {
    override val injector: ActivityDagger.ActivityComponent by lazy {
        application.injector<ActivityDagger.AppGraph>()
            .p3Builder()
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cold)
        supportFragmentManager.beginTransaction()
            .add(R.id.cl_container, LookupFragment.newInstance())
            .commitNow()
    }

}
