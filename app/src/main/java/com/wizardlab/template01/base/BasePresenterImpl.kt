package com.wizardlab.template01.base

/**
 * Template01
 * Class: BasePresenterImpl
 * Created by Wizardlab
 *
 * Description:
 */
open class BasePresenterImpl<V : BaseView> :
    BasePresenter<V> {

    protected var view: V? = null

    override fun attachView(view: V) {
        this.view = view
        this.view?.initLayout()
    }

    override fun onResume() {

    }

    override fun onPause() {

    }

    override fun detachView() {

    }
}