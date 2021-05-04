package com.wizardlab.template01.base

/**
 * Template01
 * Class: BasePresenter
 * Created by Wizardlab
 *
 * Description:
 */
interface BasePresenter<in V : BaseView> {

    fun attachView(view: V)

    fun onResume()

    fun onPause()

    fun detachView()
}