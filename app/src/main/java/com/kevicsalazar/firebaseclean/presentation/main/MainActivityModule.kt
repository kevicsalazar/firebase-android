package com.kevicsalazar.firebaseclean.presentation.main

import com.kevicsalazar.firebaseclean.presentation.PerActivity
import dagger.Binds
import dagger.Module

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
@Module
abstract class MainActivityModule {

    @Binds
    @PerActivity
    abstract fun provideMainView(activity: MainActivity): MainPresenter.View

}