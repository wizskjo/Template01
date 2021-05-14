package com.wizardlab.template01.flow.splash

import com.wizardlab.template01.base.BasePresenter
import com.wizardlab.template01.base.BaseView

/**
 * Template01
 * Class: SplashContract
 * Created by Wizardlab
 *
 * Description:
 */
object SplashContract {

    interface View : BaseView {
        fun versionOk()
        fun permissionOk()
    }

    interface Presenter : BasePresenter<View> {
        fun requestVersion()
        fun checkPermission()
    }
}