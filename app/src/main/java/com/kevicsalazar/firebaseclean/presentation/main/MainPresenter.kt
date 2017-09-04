package com.kevicsalazar.firebaseclean.presentation.main

import com.kevicsalazar.firebaseclean.domain.model.Device
import com.kevicsalazar.firebaseclean.domain.usecases.GetDevicesUseCase
import com.kevicsalazar.firebaseclean.domain.usecases.StatusUserUseCase
import com.kevicsalazar.firebaseclean.presentation.BasePresenter
import com.kevicsalazar.firebaseclean.presentation.BaseView
import com.kevicsalazar.firebaseclean.presentation.PerActivity
import io.reactivex.rxkotlin.plusAssign
import javax.inject.Inject

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
@PerActivity
class MainPresenter @Inject constructor(val view: View,
                                        val useCase1: StatusUserUseCase,
                                        val useCase2: GetDevicesUseCase) : BasePresenter() {

    fun checkSession() {
        cd += useCase1.isLogged()
                .subscribe {
                    if (it) {
                        view.onUserLogged()
                    } else {
                        view.goToLoginActivity()
                    }
                }
    }

    fun getDevices() {
        view.showProgress()
        cd += useCase2.observable()
                .subscribe({
                    view.hideProgress()
                    view.clearAdapter()
                    it.forEach { view.addDeviceToAdapter(it) }
                    view.addIfEmpty("No hay dispositivos")
                }, {
                    view.hideProgress()
                    view.showMessage("Error", it.message())
                })
    }

    interface View : BaseView {

        fun onUserLogged()

        fun goToLoginActivity()

        fun clearAdapter()

        fun addDeviceToAdapter(device: Device)

        fun addIfEmpty(message: String)

    }

}