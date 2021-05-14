package com.wizardlab.template01.base

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatDialog
import androidx.databinding.DataBindingUtil
import com.wizardlab.template01.R
import com.wizardlab.template01.databinding.ActivityBaseBinding
import com.wizardlab.template01.databinding.ActivitySideMenuBinding
import com.zeugmasolutions.localehelper.LocaleAwareCompatActivity


/**
 * Template01
 * Class: BaseActivity
 * Created by Wizardlab
 *
 * Description:
 */
abstract class BaseActivity<in V : BaseView, T : BasePresenter<V>>
    : LocaleAwareCompatActivity(), BaseView {

//    private lateinit var mApplication: MApplication
    private lateinit var baseBinding: ActivityBaseBinding
    private lateinit var sideMenuBinding: ActivitySideMenuBinding
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

        sideMenuBinding = DataBindingUtil.setContentView(this, R.layout.activity_side_menu)
        sideMenuBinding.layoutDrawer.outlineProvider = null

    }

    override fun setupActionBar(baseBinding: ActivityBaseBinding) {
        TODO("Not yet implemented")
    }

    override fun showErrorToast(error: String?) {
        TODO("Not yet implemented")
    }

    override fun showErrorToast(stringResId: Int) {
        TODO("Not yet implemented")
    }

    override fun showToastMessage(srtResId: Int) {
        TODO("Not yet implemented")
    }

    override fun showToastMessage(message: String) {
        TODO("Not yet implemented")
    }

    override fun showErrorDialog(strResId: Int) {
        TODO("Not yet implemented")
    }

    override fun showErrorDialog(title: Int, message: String) {
        TODO("Not yet implemented")
    }

    override fun showErrorDialog(title: Int, message: Int) {
        TODO("Not yet implemented")
    }

    override fun showErrorDialog(title: String, message: String) {
        TODO("Not yet implemented")
    }

    override fun showErrorDialog(message: String) {
        TODO("Not yet implemented")
    }

    override fun showSnackBar(message: String) {
        TODO("Not yet implemented")
    }

    override fun showSnackBar(srtResId: Int) {
        TODO("Not yet implemented")
    }

    override fun startProgress() {
        TODO("Not yet implemented")
    }

    override fun startCircleProgress() {
        TODO("Not yet implemented")
    }

    override fun stopProgress() {
        TODO("Not yet implemented")
    }

    override fun stopCircleProgress() {
        TODO("Not yet implemented")
    }

    override fun finishAppRemoveTask() {
        moveTaskToBack(true)
        finishAndRemoveTask()
        android.os.Process.killProcess(android.os.Process.myPid())
    }

    override fun finishApp() {
        moveTaskToBack(true)
        finish()
        android.os.Process.killProcess(android.os.Process.myPid())
    }

    override fun finishActivity() {
        moveTaskToBack(true)
        finishAndRemoveTask()
    }

    override fun onDestroy() {
        presenter.detachView()

        super.onDestroy()
    }
}