package com.kevicsalazar.firebaseclean.presentation.login

import android.os.Bundle
import com.kevicsalazar.firebaseclean.R
import com.kevicsalazar.firebaseclean.presentation.BaseActivity
import com.kevicsalazar.firebaseclean.presentation.main.MainActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import javax.inject.Inject

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
class LoginActivity : BaseActivity(), LoginPresenter.View {

    @Inject lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        btnLogin.setOnClickListener {
            presenter.register(etEmail.text.toString(), etPassword.text.toString())
        }

    }

    override fun getLayout() = R.layout.activity_login

    override fun detachFromPresenter() = presenter.detachView()

    override fun goToMainActivity() {
        startActivity<MainActivity>()
    }

    override fun showProgress() {

    }

    override fun hideProgress() {

    }

    override fun showMessage(title: String, message: String) {

    }

}