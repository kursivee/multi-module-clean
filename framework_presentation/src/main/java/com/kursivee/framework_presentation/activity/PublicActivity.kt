package com.kursivee.framework_presentation.activity

import com.kursivee.framework_domain.activity.BaseActivity
import com.kursivee.framework_domain.injector.ext.injector
import com.kursivee.framework_presentation.R

class PublicActivity : BaseActivity<ActivityDagger.ActivityComponent>(R.id.pb_loading, R.layout.activity_cold) {
    override val injector: ActivityDagger.ActivityComponent by lazy {
        application.injector<ActivityDagger.AppGraph>()
            .p3Builder()
            .build()
    }
}

