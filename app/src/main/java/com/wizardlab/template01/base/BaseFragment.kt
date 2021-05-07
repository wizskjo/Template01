package com.wizardlab.template01.base

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatDialog
import androidx.fragment.app.Fragment

/**
 * Template01
 * Class: BaseFragment
 * Created by Wizardlab
 *
 * Description:
 */

abstract class BaseFragment<in V : BaseView, T : BasePresenter<V>> :
    Fragment(), BaseView {

    protected abstract var presenter: T
    override fun getContext(): Context = requireActivity()
    private var progressDialog: AppCompatDialog? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.attachView(this as V)
    }

    open fun getBaseActivity(): BaseActivity<V, T>? {
        var baseActivity: BaseActivity<V, T>? = null
        if (activity != null && activity is BaseActivity<*, *>) {
            baseActivity = activity as BaseActivity<V, T>?
        }
        return baseActivity
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }
}