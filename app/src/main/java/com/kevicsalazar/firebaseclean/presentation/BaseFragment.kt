package com.kevicsalazar.firebaseclean.presentation

import android.content.Context
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * Created by Kevin Salazar
 */
abstract class BaseFragment : Fragment(), HasSupportFragmentInjector {

    @Inject lateinit var childFragmentInjector: DispatchingAndroidInjector<Fragment>

    /**
     * AndroidSupportInjection
     */
    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    /**
     * The onCreateView base will set the view specified in [layout].
     */
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        return inflater!!.inflate(getLayout(), container, false)
    }

    /**
     * @return fragmentInjector
     */
    override fun supportFragmentInjector(): AndroidInjector<Fragment> = childFragmentInjector

    /**
     * Add Fragment
     */
    protected fun addChildFragment(@IdRes containerViewId: Int, fragment: Fragment) {
        childFragmentManager.beginTransaction()
                .add(containerViewId, fragment)
                .commit()
    }

    /**
     * Replace Fragment
     */
    protected fun replaceChildFragment(@IdRes containerViewId: Int, fragment: Fragment) {
        childFragmentManager.beginTransaction()
                .replace(containerViewId, fragment)
                .commit()
    }

    /**
     * Specify the layout of the fragment to be inflated in the [BaseFragment.onCreateView]
     */
    protected abstract fun getLayout(): Int

    /**
     * Detach From Presenter
     */
    abstract fun detachFromPresenter()

    /**
     * Avoid memory leaks
     */
    override fun onDestroy() {
        detachFromPresenter()
        super.onDestroy()
    }

}
