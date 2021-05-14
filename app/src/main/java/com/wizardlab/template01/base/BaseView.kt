package com.wizardlab.template01.base

import android.content.Context
import androidx.annotation.StringRes
import com.wizardlab.template01.databinding.ActivityBaseBinding

/**
 * Template01
 * Class: BaseView
 * Created by Wizardlab
 *
 * Description:
 */
interface BaseView {

    fun getContext(): Context

    fun initLayout()

    fun setupActionBar(baseBinding: ActivityBaseBinding)

    fun showErrorToast(error: String?)

    fun showErrorToast(@StringRes stringResId: Int)

    fun showToastMessage(@StringRes srtResId: Int)

    fun showToastMessage(message: String)

    fun showErrorDialog(@StringRes strResId: Int)

    fun showErrorDialog(@StringRes title: Int, message: String)

    fun showErrorDialog(@StringRes title: Int, @StringRes message: Int)

    fun showErrorDialog(title: String, message: String)

    fun showErrorDialog(message: String)

    fun showSnackBar(message: String)

    fun showSnackBar(@StringRes srtResId: Int)

    fun startProgress()

    fun startCircleProgress()

    fun stopProgress()

    fun stopCircleProgress()

    fun finishAppRemoveTask()

    fun finishApp()

    fun finishActivity()
}