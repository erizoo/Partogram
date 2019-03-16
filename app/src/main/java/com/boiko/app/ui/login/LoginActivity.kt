package com.boiko.app.ui.login

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import com.boiko.app.R
import com.boiko.app.base.BaseActivity
import com.boiko.app.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : BaseActivity(), LoginMvpView {

    @Inject
    internal lateinit var presenter: LoginPresenter<LoginMvpView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        screenComponent?.inject(this)
        presenter.onAttach(this)
        progress_bar.visibility = View.GONE

        button.setOnClickListener {
            progress_bar.visibility = View.VISIBLE
            when {
                login.text.toString() == "" -> {
                    progress_bar.visibility = View.GONE
                    Snackbar.make(layout, "Введите логин", Snackbar.LENGTH_LONG).show()
                }
                password.text.toString() == "" -> {
                    progress_bar.visibility = View.GONE
                    Snackbar.make(layout, "Введите пароль", Snackbar.LENGTH_LONG).show()
                }
                else -> presenter.login(login.text.toString(), password.text.toString())
            }
        }
    }

    override fun getContentView(): Int {
        return R.layout.activity_login
    }

    override fun isSuccessfulLogin() {
        progress_bar.visibility = View.GONE
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun badLogin(message: String, nothing: Nothing?) {
        Snackbar.make(layout, "Ошибка входа", Snackbar.LENGTH_LONG).show()
    }

}
