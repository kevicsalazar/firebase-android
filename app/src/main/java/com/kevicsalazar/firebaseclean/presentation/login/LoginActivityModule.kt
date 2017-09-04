package com.kevicsalazar.firebaseclean.presentation.login

import com.kevicsalazar.firebaseclean.presentation.PerActivity
import dagger.Binds
import dagger.Module

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
@Module
abstract class LoginActivityModule {

    @Binds
    @PerActivity
    abstract fun provideLoginView(activity: LoginActivity): LoginPresenter.View

}