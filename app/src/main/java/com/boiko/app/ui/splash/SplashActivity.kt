package com.boiko.app.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.boiko.app.R
import com.boiko.app.base.BaseActivity
import com.boiko.app.ui.MainActivity
import com.boiko.app.ui.login.LoginActivity
import javax.inject.Inject


class SplashActivity : BaseActivity(), SplashMvpView {

    @Inject
    internal lateinit var presenter: SplashPresenter<SplashMvpView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        screenComponent?.inject(this)
        presenter.onAttach(this)

        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun getContentView(): Int {
        return R.layout.splash_activity
    }

    override fun isSuccessfulToken() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun badToken(message: String, nothing: Nothing?) {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

}
