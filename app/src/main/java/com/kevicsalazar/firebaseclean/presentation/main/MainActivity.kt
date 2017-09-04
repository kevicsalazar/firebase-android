package com.kevicsalazar.firebaseclean.presentation.main


import android.os.Bundle
import android.util.Log

import com.kevicsalazar.firebaseclean.R
import com.kevicsalazar.firebaseclean.domain.model.Device
import com.kevicsalazar.firebaseclean.presentation.BaseActivity
import com.kevicsalazar.firebaseclean.presentation.login.LoginActivity
import org.jetbrains.anko.startActivity
import javax.inject.Inject

class MainActivity : BaseActivity(), MainPresenter.View {

    @Inject lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.checkSession()
    }

    override fun getLayout() = R.layout.activity_main

    override fun detachFromPresenter() = presenter.detachView()

    override fun onUserLogged() {
        presenter.getDevices()
    }

    override fun goToLoginActivity() {
        startActivity<LoginActivity>()
    }

    override fun clearAdapter() {

    }

    override fun addDeviceToAdapter(device: Device) {
        Log.e(":)", device.name)
    }

    override fun addIfEmpty(message: String) {

    }

    override fun showProgress() {

    }

    override fun hideProgress() {

    }

    override fun showMessage(title: String, message: String) {

    }

}
