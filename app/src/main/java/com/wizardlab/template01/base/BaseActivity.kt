package com.wizardlab.template01.base

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatDialog
import androidx.databinding.DataBindingUtil
import com.wizardlab.template01.R
import com.wizardlab.template01.databinding.ActivityBaseBinding
import com.zeugmasolutions.localehelper.LocaleAwareCompatActivity


/**
 * Template01
 * Class: BaseActivity
 * Created by Wizardlab
 *
 * Description:
 */
abstract class BaseActivity<in V : BaseView, T : BasePresenter<V>> :
    LocaleAwareCompatActivity(), BaseView {

//    private lateinit var mApplication: MApplication
    private lateinit var baseBinding: ActivityBaseBinding
    private var progressDialog: AppCompatDialog? = null
    override fun getContext(): Context = this
    protected abstract var presenter: T

    @Suppress("UNCHECKED_CAST")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter.attachView(this as V)
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }

    protected open fun initLayout(view: View) {
        baseBinding = DataBindingUtil.setContentView(this, R.layout.activity_base)
        baseBinding.layoutAppbar.outlineProvider = null
        RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.MATCH_PARENT
        ).apply {
            baseBinding.baseRootBody.addView(view, this)
        }

        setupActionBar(baseBinding)
    }
}