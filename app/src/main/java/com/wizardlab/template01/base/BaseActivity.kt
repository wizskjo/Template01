package com.wizardlab.template01.base

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
}