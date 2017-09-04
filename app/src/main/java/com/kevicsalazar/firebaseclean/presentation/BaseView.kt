package com.kevicsalazar.firebaseclean.presentation

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
interface BaseView {

    fun showProgress()

    fun hideProgress()

    fun showMessage(title: String, message: String)

}