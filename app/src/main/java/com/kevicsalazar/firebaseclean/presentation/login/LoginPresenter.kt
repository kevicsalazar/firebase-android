package com.kevicsalazar.firebaseclean.presentation.login

import com.kevicsalazar.firebaseclean.domain.usecases.LoginUserUseCase
import com.kevicsalazar.firebaseclean.domain.usecases.RegisterUserUseCase
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
class LoginPresenter @Inject constructor(val view: View,
                                         val useCase1: RegisterUserUseCase,
                                         val useCase2: LoginUserUseCase) : BasePresenter() {

    fun register(email: String, password: String) {
        view.showProgress()
        cd += useCase1.observable(email, password)
                .subscribe({
                    view.goToMainActivity()
                }, {
                    view.hideProgress()
                    view.showMessage("Error", it.message())
                })
    }

    fun login(email: String, password: String) {
        view.showProgress()
        cd += useCase2.observable(email, password)
                .subscribe({
                    view.goToMainActivity()
                }, {
                    view.hideProgress()
                    view.showMessage("Error", it.message())
                })
    }

    interface View : BaseView {

        fun goToMainActivity()

    }

}