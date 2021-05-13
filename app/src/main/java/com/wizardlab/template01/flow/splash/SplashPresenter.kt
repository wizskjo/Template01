package com.wizardlab.template01.flow.splash

import com.wizardlab.template01.base.BasePresenterImpl

/**
 * Template01
 * Class: SplashPresenter
 * Created by Wizardlab
 *
 * Description:
 */
class SplashPresenter : BasePresenterImpl<SplashContract.View>(), SplashContract.Presenter {
    override fun requestVersion() {
        TODO("Not yet implemented")
    }

    override fun checkPermission() {
        view?.permissionOk()
    }
}