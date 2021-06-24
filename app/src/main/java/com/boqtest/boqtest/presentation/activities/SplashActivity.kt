package com.boqtest.boqtest.presentation.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.boqtest.Application
import com.example.boqtest.injection.components.DaggerActivityComponent
import com.example.boqtest.injection.modules.ComponentModule
import com.example.boqtest.presentation.activities.BaseActivity
import com.example.boqtest.presentation.activities.PhotoActivity
import com.example.boqtest.presentation.presenters.SplashPresenter
import javax.inject.Inject

class SplashActivity : BaseActivity(), SplashPresenter.ViewSurface {

    companion object IntentBuilder {
        /**
         * @return Intent that starts the SplashActivity.
         */
        fun newIntent(launchContext: Context): Intent {
            return Intent(launchContext, SplashActivity::class.java)
        }
    }

    @Inject
    lateinit var presenter: SplashPresenter

    //region Lifecycle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
        presenter.onCreate(this)
    }
    //endregion

    //region Private

    fun inject() {
        DaggerActivityComponent.builder()
            .applicationComponent(Application.applicationComponent)
            .componentModule(ComponentModule(this))
            .build()
            .inject(this)
    }

    //endregion

    //region ViewSurface
    override fun navigateToPhoto() {
        startActivity(
            PhotoActivity.newIntent(
                this
            )
        )
        finish()
    }
}