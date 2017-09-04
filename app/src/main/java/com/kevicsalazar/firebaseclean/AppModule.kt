package com.kevicsalazar.firebaseclean

import com.kevicsalazar.firebaseclean.data.DataModule
import com.kevicsalazar.firebaseclean.presentation.PerActivity
import com.kevicsalazar.firebaseclean.presentation.login.LoginActivity
import com.kevicsalazar.firebaseclean.presentation.login.LoginActivityModule
import com.kevicsalazar.firebaseclean.presentation.main.MainActivity
import com.kevicsalazar.firebaseclean.presentation.main.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
@Module(includes = arrayOf(
        DataModule::class,
        AndroidSupportInjectionModule::class))
abstract class AppModule {

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    abstract fun contributeMainActivity(): MainActivity

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(LoginActivityModule::class))
    abstract fun contributeLoginActivity(): LoginActivity

}